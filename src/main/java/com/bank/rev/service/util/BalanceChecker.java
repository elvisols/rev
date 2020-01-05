package com.bank.rev.service.util;

import com.bank.rev.dao.gen.tables.pojos.Account;
import com.bank.rev.dao.gen.tables.pojos.Transfer;
import com.bank.rev.service.AccountService;
import com.bank.rev.service.BaseService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.websocket.api.BadPayloadException;

import java.math.BigDecimal;

@Slf4j
public class BalanceChecker extends BaseService implements Chain {
    private Chain nextInChain;
    private AccountService accountService;

    public BalanceChecker() {
        AccountService.getBean();
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void process(Transfer request) throws NotFoundException, BadPayloadException {
        log.info(">>> checking balance...");
        readLock.lock();
        Account acctD = accountService.getAccountByNo(request.getDebitedAccountNo());

        if(MathUtils.lessThan(acctD.getBalance(), request.getTxnAmount())) {
            readLock.unlock();
            throw new BadPayloadException("Sorry you do not have enough balance to transfer.");
        } else {
            readLock.unlock();
            nextInChain.process(request);
        }
    }
}
