package com.bank.rev;

import com.bank.rev.controller.AccountController;
import com.bank.rev.controller.CustomerController;
import com.bank.rev.controller.StatementController;
import com.bank.rev.controller.TransferController;
import io.javalin.Javalin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.ReDocOptions;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;

import static io.javalin.apibuilder.ApiBuilder.*;

@Slf4j
public class App {

    private final Javalin app;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private App() {
        app = Javalin.create(config -> {
            config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
        });
    }

    private OpenApiOptions getOpenApiOptions() {
        Info applicationInfo = new Info().version("1.0").description("RevApp Documentation");
        return new OpenApiOptions(applicationInfo)
                .path("/swagger-docs")
                .toJsonMapper(gson::toJson)
                .activateAnnotationScanningFor("com.bank.rev.controller")
                .swagger(new SwaggerOptions("/swagger-ui").title("Rev Swagger Documentation"))
                .reDoc(new ReDocOptions("/redoc").title("Rev Redoc Documentation"));
    }

    private void doJob() {
        // define port
        app.start(7002);

        // define routes
        app.routes(() -> {
            path("transfers", () -> {
                get(TransferController.fetchTransferRecord);
                post(TransferController.doTransfer);
            });

            path("customers", () -> {
                get(CustomerController.fetchAllCustomerRecords);
                post(CustomerController.createCustomer);
                put(CustomerController.updateCustomer);
                path(":id", () -> {
                    get(CustomerController.fetchOneCustomerRecord);
                });
            });

            path("accounts", () -> {
                post(AccountController.createAccount);
                path(":custId", () -> {
                    get(AccountController.fetchAllCustomerAccountsRecords);
                });
                path("/detail/:accNo", () -> {
                    get(AccountController.fetchOneAccountRecord);
                });
            });

            path("statements", () -> {
                path(":custId", () -> {
                    get(StatementController.fetchAllCustomerStatementRecords);
                });
                path("/account/:accNo", () -> {
                    get(StatementController.fetchAllAccountStatementRecords);
                });
            });
        });

        // catch All exceptions
        app.exception(Exception.class, (e, ctx) -> {
            e.printStackTrace();
            ctx.result(e.getMessage());
        });
    }

    public static void main(String[] args) {
        new App().doJob();
    }
}
