package com.bank.rev.service.util;

import com.bank.rev.dao.gen.tables.Account;
import com.bank.rev.dao.gen.tables.Statement;
import com.bank.rev.dao.gen.tables.pojos.Transfer;
import com.bank.rev.dao.gen.tables.records.AccountRecord;
import com.bank.rev.dao.gen.tables.records.TransferRecord;
import com.bank.rev.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.impl.DSL;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


@Slf4j
public class TransferAgent extends BaseService implements Chain {
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void process(Transfer request) {
        // writeLock.lock();
        log.info(">>> transferring amount[{}{}] from account[{}] to account[{}]...", request.getTxnAmount(), request.getTxnCcy(), request.getDebitedAccountNo(), request.getCreditedAccountNo());
        DSL.using(config).transaction(configuration -> {
            // stepOne: debit txnAmt from debit account
            AccountRecord accountD =
                DSL.using(configuration)
                    .selectFrom(Account.ACCOUNT)
                    .where(Account.ACCOUNT.ACCOUNT_NO.eq(request.getDebitedAccountNo()))
                    .fetchOne();
            accountD.setBalance(accountD.getBalance().subtract(request.getTxnAmount()));
            accountD.store();

            // stepTwo: credit txnAmt into credit account
            AccountRecord accountC =
                DSL.using(configuration)
                    .selectFrom(Account.ACCOUNT)
                    .where(Account.ACCOUNT.ACCOUNT_NO.eq(request.getCreditedAccountNo()))
                    .fetchOne();
            accountC.setBalance(accountC.getBalance().add(request.getTxnAmount()));
            accountC.store();

            // stepThree: create debit statement
            DSL.using(configuration)
                    .insertInto(
                            Statement.STATEMENT,
                            Statement.STATEMENT.CUSTOMER_ID,
                            Statement.STATEMENT.ACCOUNT_NO,
                            Statement.STATEMENT.BANK_CODE,
                            Statement.STATEMENT.CCY,
                            Statement.STATEMENT.DR_CR,
                            Statement.STATEMENT.NARRATION,
                            Statement.STATEMENT.TXN_AMOUNT,
                            Statement.STATEMENT.TXN_TIMESTAMP)
                    .values(accountD.getCustomerId(),
                            request.getDebitedAccountNo(),
                            request.getBankCode(),
                            request.getTxnCcy(),
                            "D",
                            "NRTN:" + new Date().getTime() + ":" + request.getCreditedAccountNo().replaceAll("\\b(\\d{4})\\d+(\\d)", "$1*******$2") + ":" + request.getTxnNarration(),
                            request.getTxnAmount(),
                            new Timestamp(new Date().getTime())
                    )
                    .execute();

            // stepFour: create credit statement
            DSL.using(configuration)
                    .insertInto(
                            Statement.STATEMENT,
                            Statement.STATEMENT.CUSTOMER_ID,
                            Statement.STATEMENT.ACCOUNT_NO,
                            Statement.STATEMENT.BANK_CODE,
                            Statement.STATEMENT.CCY,
                            Statement.STATEMENT.DR_CR,
                            Statement.STATEMENT.NARRATION,
                            Statement.STATEMENT.TXN_AMOUNT,
                            Statement.STATEMENT.TXN_TIMESTAMP)
                    .values(accountC.getCustomerId(),
                            request.getCreditedAccountNo(),
                            request.getBankCode(),
                            request.getTxnCcy(),
                            "C",
                            "NRTN:" + new Date().getTime() + ":" + request.getDebitedAccountNo().replaceAll("\\b(\\d{4})\\d+(\\d)", "$1*******$2") + ":" + request.getTxnNarration(),
                            request.getTxnAmount(),
                            new Timestamp(new Date().getTime())
                    )
                    .execute();

            // stepFour: save transfer
            TransferRecord transfer = DSL.using(configuration)
                    .insertInto(
                            com.bank.rev.dao.gen.tables.Transfer.TRANSFER,
                            com.bank.rev.dao.gen.tables.Transfer.TRANSFER.REF,
                            com.bank.rev.dao.gen.tables.Transfer.TRANSFER.CREDITED_ACCOUNT_NO,
                            com.bank.rev.dao.gen.tables.Transfer.TRANSFER.DEBITED_ACCOUNT_NO,
                            com.bank.rev.dao.gen.tables.Transfer.TRANSFER.TXN_AMOUNT,
                            com.bank.rev.dao.gen.tables.Transfer.TRANSFER.TXN_CCY,
                            com.bank.rev.dao.gen.tables.Transfer.TRANSFER.TXN_NARRATION,
                            com.bank.rev.dao.gen.tables.Transfer.TRANSFER.TXN_TIMESTAMP,
                            com.bank.rev.dao.gen.tables.Transfer.TRANSFER.BANK_CODE)
                    .values(UUID.randomUUID().toString().replaceAll("-", ""),
                            request.getCreditedAccountNo(),
                            request.getDebitedAccountNo(),
                            request.getTxnAmount(),
                            request.getTxnCcy(),
                            request.getTxnNarration(),
                            new Timestamp(new Date().getTime()),
                            request.getBankCode()
                    )
                    .returning()
                    .fetchOne();

        });
        log.info(">>> transfer done!");
        // writeLock.unlock();
    }
}
