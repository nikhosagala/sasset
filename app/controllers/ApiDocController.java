package controllers;

import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;

public class ApiDocController extends Controller {

    @Inject
    private ApiDocController() {
    }

    public Result api() {
        return redirect("/assets/lib/swagger-ui/index.html?url=/swagger.json");
    }
}