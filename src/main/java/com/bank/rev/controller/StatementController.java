package com.bank.rev.controller;

import com.bank.rev.dao.gen.tables.pojos.Customer;
import com.bank.rev.service.CustomerService;
import com.bank.rev.service.ICustomer;
import io.javalin.http.Handler;
import io.javalin.plugin.openapi.annotations.*;

public class StatementController {

    private static final ICustomer customer = CustomerService.getBean();

    @OpenApi(
            responses = @OpenApiResponse(status = "200", content = @OpenApiContent(from = Customer.class, isArray = true))
    )
    public static final Handler fetchAllCustomerRecords = ctx -> {
        ctx.status(200);
        ctx.json(customer.getAllCustomers());
    };

    @OpenApi(
            summary = "fetch a customer by id",
            pathParams = @OpenApiParam(name = "id"),
            responses = {
                    @OpenApiResponse(status = "200", content = @OpenApiContent(from = Customer.class)),
                    @OpenApiResponse(status = "201", content = @OpenApiContent(from = Customer.class))
            }
    )
    public static final Handler fetchOneCustomerRecord = ctx -> {
        ctx.status(200);
        ctx.json(
                customer.getCustomerById(Integer.valueOf(ctx.pathParam("id"))));
    };

    @OpenApi(
            method = HttpMethod.POST,
            requestBody = @OpenApiRequestBody(content = @OpenApiContent(from = Customer.class))
    )
    public static final Handler createCustomer = ctx -> {
        Customer customerNew = ctx.bodyAsClass(Customer.class);
        customer.save(customerNew);
        ctx.status(201);
        ctx.json("Success! customer saved.");
    };

    @OpenApi(
            method = HttpMethod.PUT
    )
    public static final Handler updateCustomer = ctx -> {
        Customer u_customer = ctx.bodyAsClass(Customer.class);
        customer.update(u_customer);
        ctx.status(200);
        ctx.json("Success! customer updated.");
    };

}
