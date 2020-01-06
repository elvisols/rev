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
        Account acctC = accountService.getAccountByNo(request.getCreditedAccountNo());
        Account acctD = accountService.getAccountByNo(request.getDebitedAccountNo());
        readLock.unlock();
        if(acctC == null || acctD == null) {
            throw new NotFoundException("Sorry we could not retrieve your account details.");
        } else {
            nextInChain.process(request);
        }
    }
}
