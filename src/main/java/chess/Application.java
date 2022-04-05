package chess;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Application {

    public static void main(final String... args) {
        port(8081);
        staticFileLocation("/static");
        final var board = Board.create();
        get("/", (req, res) -> {
            return new ModelAndView(board.toMap(), "index.html");
        }, new HandlebarsTemplateEngine());

        post("/move", (req, res) -> {
            final var request = Request.of(req.body());
            board.move(request.command());
            res.redirect("/");
            return null;
        });

        exception(Exception.class, (exception, request, response) -> {
            response.status(400);
            response.body(exception.getMessage());
        });
    }
}
