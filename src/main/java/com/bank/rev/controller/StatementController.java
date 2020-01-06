package com.bank.rev.controller;

import com.bank.rev.dao.gen.tables.pojos.Statement;
import com.bank.rev.service.IStatement;
import com.bank.rev.service.StatementService;
import io.javalin.http.Handler;
import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiContent;
import io.javalin.plugin.openapi.annotations.OpenApiParam;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;

public class StatementController {

    private static final IStatement statementService = StatementService.getBean();

    @OpenApi(
            summary = "Customer statements",
            description = "Fetch all customer statements",
            pathParams = @OpenApiParam(name = "custId"),
            responses = @OpenApiResponse(status = "200", content = @OpenApiContent(from = Statement.class, isArray = true))
    )
    public static final Handler fetchAllCustomerStatementRecords = ctx -> {
        ctx.status(200);
        ctx.json(statementService.getAllStatementByCustomer(ctx.pathParam("custId", Integer.class).get()));
    };

    @OpenApi(
            summary = "Account statements",
            description = "fetch an account statements",
            pathParams = @OpenApiParam(name = "accNo"),
            responses = @OpenApiResponse(status = "200", content = @OpenApiContent(from = Statement.class, isArray = true))
    )
    public static final Handler fetchAllAccountStatementRecords = ctx -> {
        ctx.status(200);
        ctx.json(statementService.getAllStatementByAccount(ctx.pathParam("accNo")));
    };

}
