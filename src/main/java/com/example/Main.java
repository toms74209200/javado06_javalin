package com.example;

import io.javalin.Javalin;

import java.util.Objects;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class Main {
    public static void main(String ... args) {

        Javalin app = Javalin.create(config -> {
//            config.addSinglePageRoot("", "index.html");
            config.addStaticFiles("/public");
        });
        app.start(7000);

        app.routes(() -> {
            path("/calc", () -> {
                get(":exec/:a/:b", ctx -> {
                    String exec = ctx.pathParam("exec");
                    int a = Integer.parseInt(ctx.pathParam("a"));
                    int b = Integer.parseInt(ctx.pathParam("b"));
                    int result = CalcResource.exec(exec, a, b);
                    ctx.result(String.valueOf(result));
                });
            });
        });

        app.routes(() -> {
            path("/product", () -> {
                get(ctx -> {
                    ctx.json(ProductResource.getProduct());
                });
                get("/all", ctx -> {
                    ctx.json(ProductResource.getProducts());
                });
                get("/:id", ctx -> {
                    int id = Integer.parseInt(ctx.pathParam("id"));
                    Product product = new Product();
                    product = ProductResource.getProduct(id);
                    if (Objects.nonNull(product)) {
                        ctx.json(product);
                    } else {
                        ctx.status(500);
                    }
                });
            });
        });
        app.post("/product", ctx -> {
            if (ProductResource.postProducts(ctx.bodyAsClass(Product.class))) {
                ctx.status(200);
            } else {
                ctx.status(500);
            };
        });
        app.put("/product/:id", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            if (ProductResource.putProducts(id, ctx.bodyAsClass(Product.class))) {
                ctx.status(200);
            } else {
                ctx.status(500);
            };
        });
        app.delete("/product/:id", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            if (ProductResource.deleteProduct(id)) {
                ctx.status(200);
            } else {
                ctx.status(500);
            };
        });
    }
}