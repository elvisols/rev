package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.daos.TransferDao;
import com.bank.rev.dao.gen.tables.pojos.Transfer;

public class TransferService extends BaseService implements ITransfer {
    private static TransferDao transferDao;

    private TransferService() {}

    public static TransferService getBean() {
        transferDao = Factory.instanceDao;
        return Factory.instanceService;
    }

    @Override
    public Transfer doTransfer(Transfer transfer) {
        return null;
    }

    // thread safe java class loader
    private static class Factory {
        static final TransferService instanceService = new TransferService();
        static final TransferDao instanceDao = new TransferDao(config);
    }
}
