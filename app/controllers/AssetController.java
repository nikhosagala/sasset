package controllers;

import com.google.inject.Inject;
import id.co.telkom.fam.models.Asset;
import id.co.telkom.fam.models.json.AssetSummary;
import id.co.telkom.fam.utils.Config;
import io.ebean.Ebean;
import io.ebean.RawSql;
import io.ebean.RawSqlBuilder;
import io.ebean.SqlRow;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Api(value = "Asset")
@SuppressWarnings("unchecked")
public class AssetController extends ApplicationController {

    @Inject
    private AssetController() {
        super(Asset.class);
    }

    @ApiOperation(
            value = "Get Asset Summary",
            notes = "Return Asset Summary",
            produces = "application/json",
            response = AssetSummary.class,
            httpMethod = "GET"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    dataType = "Long",
                    paramType = "path",
                    value = "0"
            ),
            @ApiImplicitParam(
                    name = "assetType",
                    dataType = "String",
                    paramType = "query",
                    value = "AC"
            ),
            @ApiImplicitParam(
                    name = "limit",
                    dataType = "Integer",
                    paramType = "query",
                    value = "0"),
            @ApiImplicitParam(
                    name = "offset",
                    dataType = "Integer",
                    paramType = "query",
                    value = "1"),
    })
    public CompletionStage<Result> getAssetSummary(Long id, String assetType, int offset, int limit) {
        List<AssetSummary> assetSummaryList = getAssetSummary(id, assetType);
        CompletionStage<Result> resultCompletionStage;
        try {
            resultCompletionStage = CompletableFuture.completedFuture(ok(
                    Config.getInstance()
                            .getSuccessJson(assetSummaryList.size(), limit, offset, assetSummaryList)));
            return resultCompletionStage;
        } catch (Exception e) {
            e.printStackTrace();
            resultCompletionStage = CompletableFuture.completedFuture(badRequest(Config.getInstance().getBadRequestJson()));
            return resultCompletionStage;
        }
    }

    @ApiOperation(
            value = "Get Assets",
            notes = "Return Asset List",
            response = Asset.class,
            httpMethod = "GET"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "filter",
                    dataType = "id.co.telkom.fam.models.Asset",
                    paramType = "query",
                    value = "[{\"property\":\"name\", \"operator\":\"eq\", \"values\":[{\"value\":\"abcd\"}]}]")})
    @Override
    public CompletionStage<Result> gets(String filter, String sort, int offset, int limit) {
        return super.gets(filter, sort, offset, limit);
    }

    @ApiOperation(
            value = "Get Asset by ID",
            notes = "Return Asset by ID",
            response = Asset.class,
            httpMethod = "GET"
    )
    @ApiImplicitParams({@ApiImplicitParam(name = "id", dataType = "Long", paramType = "path", value = "1")})
    @Override
    public CompletionStage<Result> get(Long id) {
        return super.get(id);
    }

    @Override
    public CompletionStage<Result> delete(Long id) {
        return super.delete(id);
    }

    @Override
    public CompletionStage<Result> submit() {
        return super.submit();
    }

    @Override
    public CompletionStage<Result> update() {
        return super.update();
    }

    private List<AssetSummary> getAssetSummary(Long id, String assetType) {
        List<AssetSummary> assetSummaries = new ArrayList<>();
        String query = "select o.id AS id, t.name AS treg, w.name AS witel, o.name AS office, qty " +
                "from office AS o " +
                "left join " +
                "(select id, treg_id, name " +
                "from witel) AS w " +
                "on o.witel_id = w.id " +
                "left join " +
                "(select id, name " +
                "from treg) AS t " +
                "on w.treg_id = t.id " +
                "left join" +
                "(select location.office_id, count(location.office_id) as qty " +
                "from asset, location " +
                "where case when :assetType = '' then asset.location_id = location.id else asset.location_id = location.id  AND asset.asset_type_id = (select asset_type.id from asset_type where asset_type.name = :assetType) end " +
                "group by location.office_id) AS location " +
                "on o.id = location.office_id " +
                "where case when :officeId != 0 then o.id = :officeId and qty > 0 else qty > 0 end " +
                "order by o.id";

        String queryDetail = "select asset.id " +
                "from asset " +
                "left join " +
                "(select location.id, location.office_id " +
                "from location) as location " +
                "on asset.location_id = location.id " +
                "where location.office_id = :officeId";

        RawSql rawSql = RawSqlBuilder.parse(queryDetail).create();

        List<SqlRow> sqlRows = Ebean.createSqlQuery(query).setParameter("officeId", id).setParameter("assetType", assetType).findList();
        for (SqlRow sqlRow : sqlRows) {
            AssetSummary assetSummary = new AssetSummary();
            assetSummary.id = sqlRow.getLong("id");
            assetSummary.treg = sqlRow.getString("treg");
            assetSummary.witel = sqlRow.getString("witel");
            assetSummary.office = sqlRow.getString("office");
            assetSummary.quantity = sqlRow.getInteger("qty");
            assetSummary.details = Ebean.find(Asset.class).setRawSql(rawSql).setParameter("officeId", assetSummary.id).findList();
            assetSummaries.add(assetSummary);
        }
        return assetSummaries;
    }
}
