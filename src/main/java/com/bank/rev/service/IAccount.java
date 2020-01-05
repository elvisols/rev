package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.pojos.Account;

import java.util.List;

public interface IAccount {
    Account getAccountByNo(String acctNo);
    void save(Account account);
    List<Account> getAllAccountByCustomer(int custid);
}
