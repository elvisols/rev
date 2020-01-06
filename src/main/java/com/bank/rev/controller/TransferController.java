package com.bank.rev.controller;

import com.bank.rev.dao.gen.tables.pojos.Customer;
import com.bank.rev.dao.gen.tables.pojos.Transfer;
import com.bank.rev.service.ITransfer;
import com.bank.rev.service.TransferService;
import io.javalin.http.Handler;
import io.javalin.plugin.openapi.annotations.*;

public class TransferController {

    private static final ITransfer request = TransferService.getBean();

    @OpenApi(
            summary = "fund transfer",
            description = "transfer fund between accounts",
            method = HttpMethod.POST,
            requestBody = @OpenApiRequestBody(content = @OpenApiContent(from = Transfer.class)),
            responses = @OpenApiResponse(status = "200", content = @OpenApiContent(from = Transfer.class))
    )
    public static final Handler doTransfer = ctx -> {
        Transfer newTransfer = ctx.bodyAsClass(Transfer.class);
        request.transferFacade(newTransfer);
        ctx.status(200);
        ctx.result("Success! " + newTransfer.getTxnAmount() + " transferred to " + newTransfer.getCreditedAccountNo() + ".");
    };

    @OpenApi(
            summary = "transfer details",
            description = "fetch transfer details",
            responses = {
                    @OpenApiResponse(status = "200", content = @OpenApiContent(from = Transfer.class, isArray = true))
            }
    )
    public static final Handler fetchTransferRecord = ctx -> {
        ctx.status(200);
        ctx.json(request.getTransferRecords());
    };

}
