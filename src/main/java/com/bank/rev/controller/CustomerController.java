package com.bank.rev.controller;

import com.bank.rev.dao.gen.tables.pojos.Customer;
import com.bank.rev.service.CustomerService;
import com.bank.rev.service.ICustomer;
import io.javalin.http.Handler;

import java.util.HashMap;
import java.util.List;

public class CustomerController {

    private static ICustomer customer = CustomerService.getBean();

    public static final Handler fetchAllCustomerRecords = ctx -> {
        List<Customer> c = customer.getAllCustomers();
        System.out.println(c);
        ctx.json(c);
    };

    public static final Handler fetchOneCustomerRecord = ctx -> {
        Customer c = customer.getCustomerById(Integer.valueOf(ctx.pathParam("id")));
        System.out.println(c);
        ctx.json(c);
    };

    public static final Handler createCustomer = ctx -> {
        customer.save(ctx.bodyAsClass(Customer.class));
        ctx.json(new HashMap<>().put("response", "Success! customer saved."));
    };

}
