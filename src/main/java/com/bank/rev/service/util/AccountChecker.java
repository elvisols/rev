package com.bank.rev.service.util;

import com.bank.rev.dao.gen.tables.pojos.Account;
import com.bank.rev.dao.gen.tables.pojos.Transfer;
import com.bank.rev.service.AccountService;
import com.bank.rev.service.BaseService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountChecker extends BaseService implements Chain {
    private Chain nextInChain;
    private AccountService accountService;

    public AccountChecker() {
        this.accountService = AccountService.getBean();
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void process(Transfer request) throws NotFoundException {
        log.info(">>> checking accounts...");
        readLock.lock();
        Account acctC = null, acctD = null;
        try{
            System.out.printf("Thread[%s] checking account \n", Thread.currentThread().getName());
            acctC = accountService.getAccountByNo(request.getCreditedAccountNo());
            acctD = accountService.getAccountByNo(request.getDebitedAccountNo());
            if(acctC == null || acctD == null) {
                throw new NotFoundException("Sorry["+Thread.currentThread().getName()+"] we could not retrieve your account details.");
            } else {
                // check balance
                nextInChain.process(request);
            }
        } catch (NotFoundException nfe) {
            System.out.printf("terminating account checker...thread[%s] because of accC[%s] accD[%s]\n", Thread.currentThread().getName(), acctC, acctD);
            throw nfe;
        } finally {
            readLock.unlock();
        }
    }
}
