package com.bank.rev.controller;

import io.javalin.http.Handler;

public class CustomerController {

    public static final Handler fetchAllRecords = ctx -> {
        ctx.json("Hello - " + ctx.path());
    };

    public static final Handler fetchOneRecord = ctx -> {
        ctx.json("Hello - " + ctx.pathParam("accountNo") + " queryString: " + ctx.queryParam("name"));
    };

    public static final Handler createAccount = ctx -> {
        ctx.json("account created " + ctx.body());
    };

}
