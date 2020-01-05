package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.daos.AccountDao;
import com.bank.rev.dao.gen.tables.pojos.Account;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class AccountService extends BaseService implements IAccount {
    private static AccountDao accountDao;

    private AccountService() {}

    public static AccountService getBean() {
        accountDao = Factory.instanceDao;
        return Factory.instanceService;
    }

    @Override
    public Account getAccountByNo(String acctNo) {
        readLock.lock();
        List<Account> accts = accountDao.fetchByAccountNo(acctNo);
        readLock.unlock();
        return accts.size() > 0 ? accts.get(0) : new Account();
    }

    @Override
    public void save(Account account) {
        writeLock.lock();
        accountDao.insert(account);
        writeLock.unlock();
    }

    @Override
    public List<Account> getAllAccountByCustomer(int custid) {
        readLock.lock();
        List<Account> accts = accountDao.fetchByCustomerId(custid);
        readLock.unlock();
        return accts;
    }

    // thread safe java class loader
    private static class Factory {
        static final AccountService instanceService = new AccountService();
        static final AccountDao instanceDao = new AccountDao(config);
    }
}
