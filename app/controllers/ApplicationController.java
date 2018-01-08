package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.openbox.sasset.models.BaseModel;
import id.openbox.sasset.utils.Config;
import id.openbox.sasset.utils.api.ApiResponse;
import io.ebean.Finder;
import io.ebean.Query;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@SuppressWarnings("unchecked")
public class ApplicationController<T extends BaseModel> extends Controller {
    private CompletionStage<Result> resultCompletionStage;
    private final Class<T> appClass;
    private Finder<Long, T> find;

    ApplicationController(Class appClass) {
        this.appClass = appClass;
        find = new Finder<Long, T>(appClass);
    }

    public CompletionStage<Result> gets(String filter, String sort, int offset, int limit) {
        try {
            Query query = find.query("order by id");
            List<T> T = ApiResponse.getInstance().getResponse(query, sort, filter, offset, limit);
            resultCompletionStage = CompletableFuture.completedFuture(ok(
                    Config.getInstance()
                            .getSuccessJson(T.size(), limit, offset, T)));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            resultCompletionStage = CompletableFuture.completedFuture(badRequest(Config.getInstance().getBadRequestJson()));
        }
        return resultCompletionStage;
    }

    public CompletionStage<Result> get(Long id) {
        try {
            T found = find.byId(id);
            if (found == null) {
                resultCompletionStage = CompletableFuture.completedFuture(notFound(Config.getInstance().getNotFoundJson(appClass.getClass().toString())));
            }
            resultCompletionStage = CompletableFuture.completedFuture(ok(Config.getInstance().getSuccessJson(found)));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            resultCompletionStage = CompletableFuture.completedFuture(badRequest(Config.getInstance().getBadRequestJson()));
        }
        return resultCompletionStage;
    }

    public CompletionStage<Result> submit() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = request().body().asJson();
            T model = objectMapper.readValue(node.toString(), appClass);
            doSave(model);
            resultCompletionStage = CompletableFuture.completedFuture(ok(Config.getInstance().getSuccessJson(model)));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            resultCompletionStage = CompletableFuture.completedFuture(badRequest(Config.getInstance().getBadRequestJson()));
        }
        return resultCompletionStage;
    }

    public CompletionStage<Result> update() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = request().body().asJson();
            T find = this.find.byId(node.findPath("id").asLong());
            Logger.debug(node.toString() + " " + find);
            if (find == null) {
                resultCompletionStage = CompletableFuture.completedFuture(notFound(Config.getInstance().getNotFoundJson(appClass.getClass().toString())));
            }
            T update = objectMapper.readValue(node.toString(), appClass);
            if (find == update) {
                resultCompletionStage = CompletableFuture.completedFuture(ok(Config.getInstance().getSuccessJson("data not change", update)));
            }
            doUpdate(update);
            resultCompletionStage = CompletableFuture.completedFuture(ok(Config.getInstance().getSuccessJson(update)));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            resultCompletionStage = CompletableFuture.completedFuture(badRequest(Config.getInstance().getBadRequestJson()));
        }
        return resultCompletionStage;
    }

    public CompletionStage<Result> delete(Long id) {
        try {
            T find = this.find.byId(id);
            if (find == null) {
                resultCompletionStage = CompletableFuture.completedFuture(notFound(Config.getInstance().getNotFoundJson(appClass.getClass().toString())));
            }
            doDelete(find);
            resultCompletionStage = CompletableFuture.completedFuture(ok(Config.getInstance().getSuccessJson(find)));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            resultCompletionStage = CompletableFuture.completedFuture(badRequest(Config.getInstance().getBadRequestJson()));
        }
        return resultCompletionStage;
    }

    private void doSave(T model) {
        model.createdAt = new Date();
        model.updatedAt = new Date();
        model.save();
    }

    private void doUpdate(T model) {
        model.updatedAt = new Date();
        model.update();
    }

    private void doDelete(T model) {
        model.updatedAt = new Date();
        model.delete();
    }
}
