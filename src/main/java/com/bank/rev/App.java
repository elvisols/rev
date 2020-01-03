package com.bank.rev;

import com.bank.rev.controller.CustomerController;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.plugin.metrics.MicrometerPlugin;

import java.util.HashMap;
import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {

    private final Javalin app;

    private App() {
        app = Javalin.create(config -> {
//            config.addStaticFiles("/public");
//            config.requestLogger((ctx, ms) -> {
//                System.out.printf("ctx(%s), ms(%s)\n", ctx.fullUrl(), ms.longValue());
//            });
            config.registerPlugin(new RouteOverviewPlugin("/routes"));
//            config.registerPlugin(new MicrometerPlugin());
        });
    }

    private void doJob() {
        // define port
        app.start(7001);
        // define routes
        app.routes(() -> {
            path("customers", () -> {
                get(CustomerController.fetchAllRecords);
                post(CustomerController.createAccount);
                path(":accountNo", () -> {
                    get(CustomerController.fetchOneRecord);
                });
            });
        });
        // define general exceptions
        app.exception(Exception.class, (e, ctx) -> {
            Map<String,String> error = new HashMap<String,String>();
            error.put("reason", "generic exception caught!");
            ctx.json(error);
        });
    }

    public static void main(String[] args) {
        new App().doJob();
    }
}
