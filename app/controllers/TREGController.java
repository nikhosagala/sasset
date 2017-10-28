package controllers;

import com.google.inject.Inject;
import id.co.telkom.fam.models.TREG;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

@Api(value = "TREG")
public class TREGController extends ApplicationController {

    @Inject
    private TREGController() {
        super(TREG.class);
    }

    @ApiOperation(
            value = "Get TREG",
            notes = "Return list of TREG",
            response = TREG.class,
            httpMethod = "GET"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "limit", dataType = "Integer", paramType = "query", value = "10"),
            @ApiImplicitParam(name = "offset", dataType = "Integer", paramType = "query", value = "0"),
            @ApiImplicitParam(
                    name = "sort",
                    dataType = "id.co.telkom.fam.models.TREG",
                    paramType = "query",
                    value = "[{\"property\":\"name\", \"direction\" : \"asc\"}]"
            ),
            @ApiImplicitParam(
                    name = "filter",
                    dataType = "id.co.telkom.fam.models.TREG",
                    paramType = "query",
                    value = "[{\"property\":\"name\", \"operator\":\"eq\", \"values\":[{\"value\":\"abcd\"}]}]"
            )
    })
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public CompletionStage<Result> gets(String filter, String sort, int offset, int limit) {
        return super.gets(filter, sort, offset, limit);
    }
}
