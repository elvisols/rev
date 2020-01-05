package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.daos.TransferDao;
import com.bank.rev.dao.gen.tables.pojos.Transfer;
import com.bank.rev.service.util.AccountChecker;
import com.bank.rev.service.util.BalanceChecker;
import com.bank.rev.service.util.Chain;
import com.bank.rev.service.util.TransferAgent;
import javassist.NotFoundException;

import java.util.List;

public class TransferService extends BaseService implements ITransfer {
    private static TransferDao transferDao;

    private TransferService() {}

    public static TransferService getBean() {
        transferDao = Factory.instanceDao;
        return Factory.instanceService;
    }

    @Override
    public void transferFacade(Transfer request) throws NotFoundException {
        Chain checkAccount = new AccountChecker();
        Chain checkBalance = new BalanceChecker();
        Chain doTransfer = new TransferAgent();

        checkAccount.setNextChain(checkBalance);
        checkBalance.setNextChain(doTransfer);

        checkAccount.process(request);
    }

    @Override
    public List<Transfer> getTransferRecords() {
        return transferDao.findAll();
    }

    // thread safe java class loader
    private static class Factory {
        static final TransferService instanceService = new TransferService();
        static final TransferDao instanceDao = new TransferDao(config);
    }
}
