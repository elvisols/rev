package com.bank.rev;

import com.bank.rev.controller.CustomerController;
import io.javalin.Javalin;
import io.javalin.http.InternalServerErrorResponse;
import io.javalin.http.staticfiles.Location;
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

    private App() {
        app = Javalin.create(config -> {
            config.enableWebjars();
            config.addStaticFiles("/webjars", Location.EXTERNAL);
            config.defaultContentType = "application.json";
            config.requestLogger((ctx, ms) -> {
                log.info("ctx({}), ms({})", ctx.fullUrl(), ms.longValue());
            });
            config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
        });
    }

    private OpenApiOptions getOpenApiOptions() {
        Info applicationInfo = new Info()
                .version("1.0")
                .description("RevApp Documentation");
        return new OpenApiOptions(applicationInfo)
                .path("/swagger-docs")
                .activateAnnotationScanningFor("com.bank.rev.controller")
                .swagger(new SwaggerOptions("/swagger-ui").title("My Swagger Documentation"))
                .reDoc(new ReDocOptions("/redoc").title("My ReDoc Documentation"));
    }

    private void doJob() {
        // define port
        app.start(7001);

        // define routes
        app.routes(() -> {
            path("customers", () -> {
                get(CustomerController.fetchAllCustomerRecords);
                post(CustomerController.createCustomer);
                put(CustomerController.updateCustomer);
                path(":id", () -> {
                    get(CustomerController.fetchOneCustomerRecord);
                });
            });
        });

        // define general exceptions
        app.exception(Exception.class, (e, ctx) -> {
            e.printStackTrace();
            ctx.json(new InternalServerErrorResponse(e.getMessage()));
            // Map<String,String> error = new HashMap<String,String>();
            // error.put("reason", "generic exception caught!");
            // ctx.json(error);
        });
    }

    public static void main(String[] args) {
        new App().doJob();
    }
}
