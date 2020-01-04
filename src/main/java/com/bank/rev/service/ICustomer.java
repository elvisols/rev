package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.pojos.Customer;

import java.util.List;

public interface ICustomer {
    Customer getCustomerById(int id);
    void update(Customer customer);
    void save(Customer customer);
    List<Customer> getAllCustomers();
}
