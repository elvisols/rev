package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.daos.StatementDao;
import com.bank.rev.dao.gen.tables.pojos.Statement;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StatementService extends BaseService implements IStatement {
    private static StatementDao statementDao;

    private StatementService() {}

    public static StatementService getBean() {
        statementDao = Factory.instanceDao;
        return Factory.instanceService;
    }

    @Override
    public List<Statement> getAllStatementByCustomer(int custId) {
        readLock.lock();
        List<Statement> stmts = statementDao.fetchByCustomerId(custId);
        readLock.unlock();
        return stmts;
    }

    @Override
    public List<Statement> getAllStatementByAccount(String acctNo) {
        readLock.lock();
        List<Statement> stmts = statementDao.fetchByAccountNo(acctNo);
        readLock.unlock();
        return stmts;
    }

    // thread safe java class loader
    private static class Factory {
        static final StatementService instanceService = new StatementService();
        static final StatementDao instanceDao = new StatementDao(config);
    }
}
