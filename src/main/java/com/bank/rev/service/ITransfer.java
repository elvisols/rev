package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.pojos.Transfer;

public interface ITransfer {
    Transfer doTransfer(Transfer transfer);
}
