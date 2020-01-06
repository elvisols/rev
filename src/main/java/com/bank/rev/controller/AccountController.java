package com.bank.rev.controller;

import com.bank.rev.dao.gen.tables.pojos.Account;
import com.bank.rev.service.AccountService;
import com.bank.rev.service.IAccount;
import io.javalin.http.Handler;
import io.javalin.plugin.openapi.annotations.*;

public class AccountController {

    private static final IAccount accountService = AccountService.getBean();

    @OpenApi(
            summary = "Customer accounts",
            description = "Fetch all customer accounts",
            pathParams = @OpenApiParam(name = "custId"),
            responses = @OpenApiResponse(status = "200", content = @OpenApiContent(from = Account.class, isArray = true))
    )
    public static final Handler fetchAllCustomerAccountsRecords = ctx -> {
        ctx.status(200);
        ctx.json(accountService.getAllAccountByCustomer(ctx.pathParam("custId", Integer.class).get()));
    };

    @OpenApi(
            summary = "Account detail",
            description = "fetch an account detail by accountNo",
            pathParams = @OpenApiParam(name = "accNo"),
            responses = {
                    @OpenApiResponse(status = "200", content = @OpenApiContent(from = Account.class))
            }
    )
    public static final Handler fetchOneAccountRecord = ctx -> {
        ctx.status(200);
        ctx.json(accountService.getAccountByNo(ctx.pathParam("accNo")));
    };

    @OpenApi(
            summary = "Account creation",
            description = "create a new account number",
            method = HttpMethod.POST,
            requestBody = @OpenApiRequestBody(content = @OpenApiContent(from = Account.class)) // Todo: replace with AccountDTO
    )
    public static final Handler createAccount = ctx -> {
        Account accountNew = ctx.bodyAsClass(Account.class);
        accountService.save(accountNew);
        ctx.status(201);
        ctx.json("Success! account created.");
    };

}
