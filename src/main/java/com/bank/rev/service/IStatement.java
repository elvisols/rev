package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.pojos.Statement;

import java.util.List;

public interface IStatement {
    void save(Statement statement);
    List<Statement> getAllStatementByCustomer(int custId);
    List<Statement> getAllStatementByAccount(String acctNo);
}
