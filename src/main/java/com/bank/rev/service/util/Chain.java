package com.bank.rev.service.util;

import com.bank.rev.dao.gen.tables.pojos.Transfer;
import javassist.NotFoundException;

public interface Chain {

    public void setNextChain(Chain nextChain);

    public void process(Transfer request) throws NotFoundException;

}
