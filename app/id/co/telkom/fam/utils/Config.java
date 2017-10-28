package id.co.telkom.fam.utils;

import com.fasterxml.jackson.databind.JsonNode;
import play.Environment;
import play.libs.Json;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Config {
    private static Config instance = null;
    private NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
    private NumberFormat cformat = new DecimalFormat("#,##0");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private SimpleDateFormat sdfDateOnly = new SimpleDateFormat("dd-MM-yyyy");

    @SuppressWarnings("rawtypes")
    private UniversalResponse response = new UniversalResponse();

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public Double currencyFormat(Object arg0) {
        Number aNumber = 0;
        try {
            aNumber = format.parse(arg0.toString());
        } catch (ParseException e1) {
            aNumber = 0;
        }
        return aNumber.doubleValue();
    }

    public String currencyText(double arg0) {
        return cformat.format(arg0);
    }

    public String getStringDate(Date date) {
        if (date != null) {
            return sdf.format(date);
        } else {
            return null;
        }
    }

    public String getStringDateOnly(Date date) {
        if (date != null) {
            return sdfDateOnly.format(date);
        } else {
            return null;
        }
    }

    public JsonNode getUnAuthorizedJson() {
        response.setResponse(
                401, "", Constants.UNAUTHORIZED_MESSAGE, 1, Constants.UNAUTHORIZED_MESSAGE, 1, 1);
        return Json.toJson(response);
    }

    public JsonNode getBadRequestJson() {
        response.setResponse(
                500, "", Constants.BAD_REQUEST_MESSAGE, 1, Constants.BAD_REQUEST_MESSAGE, 1, 1);
        return Json.toJson(response);
    }

    public JsonNode getBadRequestJson(String message) {
        response.setResponse(500, "", Constants.BAD_REQUEST_MESSAGE, 1, message, 1, 1);
        return Json.toJson(response);
    }

    public JsonNode getBadRequestJson(int responseCode, String message) {
        response.setResponse(responseCode, "", Constants.BAD_REQUEST_MESSAGE, 1, message, 1, 1);
        return Json.toJson(response);
    }

    public JsonNode getJsonError() {
        response.setResponse(
                500, "", Constants.JSON_ERROR_MESSAGE, 1, Constants.JSON_ERROR_MESSAGE, 1, 1);
        return Json.toJson(response);
    }

    public JsonNode getMissingPasswordJson() {
        response.setResponse(
                500, "", Constants.MISSING_PASSXWORD_MESSAGE, 1, Constants.MISSING_PASSXWORD_MESSAGE, 1, 1);
        return Json.toJson(response);
    }

    public JsonNode getNotFoundJson(String message) {
        response.setResponse(
                404, "", message.concat(" not found"), 1, message.concat(" not found"), 1, 1);
        return Json.toJson(response);
    }

    public JsonNode getSuccessJson(Object object) {
        response.setResponse(200, "success", "", 1, object, 1, 1);
        return Json.toJson(response);
    }

    public JsonNode getSuccessJson(String message, Object object) {
        response.setResponse(200, message, "", 1, object, 1, 1);
        return Json.toJson(response);
    }

    public JsonNode getSuccessJson(int totalRecord, int limit, int offset, Object object) {
        response.setResponse(200, "success", "", totalRecord, object, limit, offset);
        return Json.toJson(response);
    }

    public JsonNode getCustomJson(int responseCode, String message, Object object) {
        response.setResponse(responseCode, message, "", 1, object, 1, 1);
        return Json.toJson(response);
    }

    public String getPath() {
        String path;
        try {
            path = Environment.simple().rootPath() + File.separator;
        } catch (RuntimeException e) {
            path = "";
        }
        return path;
    }
}
