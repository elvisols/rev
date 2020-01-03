package com.bank.rev.service;

import com.bank.rev.dao.gen.tables.daos.CustomerDao;
import com.bank.rev.dao.gen.tables.pojos.Customer;
import com.bank.rev.util.Config;
import org.jooq.Configuration;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomer {
    private static CustomerDao customerDao;

    private CustomerService() {}

    public static CustomerService getBean() {
        Configuration config = null;
        try {
            config = Config.getInstance().getConfiguration();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO:
        // Optimize 'CustomerDao'
        customerDao = new CustomerDao(config);
        return Factory.instance;
    }

    @Override
    public Customer getCustomerById(int id) throws SQLException {
        return customerDao.fetchOneById(id);
    }

    @Override
    public void save(Customer customer) throws SQLException {
        customerDao.update(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    // thread safe java class loader
    private static class Factory {
        static CustomerService instance = new CustomerService();
    }
}
