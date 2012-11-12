package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result ventures() {
        return ok(comingSoon.render("ventures"));
    }

    public static Result method() {
        return ok(comingSoon.render("method"));
    }

    public static Result vision() {
        return ok(comingSoon.render("vision"));
    }

    public static Result contact() {
        return ok(comingSoon.render("contact"));
    }
}