package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.pojos.Transfer;
import javassist.NotFoundException;

import java.util.List;

public interface ITransfer {
    void transferFacade(Transfer request) throws NotFoundException;
    List<Transfer> getTransferRecords();
}
