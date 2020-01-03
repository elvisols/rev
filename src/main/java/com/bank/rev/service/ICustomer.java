package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.pojos.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomer {
    public Customer getCustomerById(int id) throws SQLException;
    public void save(Customer customer) throws SQLException;
    public List<Customer> getAllCustomers();
}
