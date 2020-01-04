package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.daos.CustomerDao;
import com.bank.rev.dao.gen.tables.pojos.Customer;
import com.bank.rev.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Configuration;
import org.slf4j.Logger;

import java.sql.SQLException;
import java.util.List;

@Slf4j
public class CustomerService implements ICustomer {
    private static CustomerDao customerDao;
    private static Configuration config;

    private CustomerService() {}

    public static CustomerService getBean() {
        log.info("\u001B[32m" + "calling CustomerServiceBean..." +  "\u001B[0m");
        try { config = Config.getInstance().getConfiguration(); } catch (SQLException e) { e.getMessage(); }
        customerDao = Factory.instanceDao;
        return Factory.instanceService;
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.fetchOneById(id);
    }

    @Override
    public void save(Customer customer) {
        customerDao.insert(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    // thread safe java class loader
    private static class Factory {
        static final CustomerService instanceService = new CustomerService();
        static final CustomerDao instanceDao = new CustomerDao(config);
    }
}
