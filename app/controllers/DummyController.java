package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.telkom.fam.models.AssetType;
import id.co.telkom.fam.models.json.Maintenance;
import id.co.telkom.fam.models.json.Menu;
import id.co.telkom.fam.utils.Config;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class DummyController extends Controller {
    private List<Maintenance> maintenanceList = new ArrayList<>();
    private CompletionStage<Result> resultCompletionStage;

    public CompletionStage<Result> getMaintenance() {
        resultCompletionStage = CompletableFuture.completedFuture(ok(Config.getInstance().getSuccessJson(maintenanceList)));
        return resultCompletionStage;
    }

    public CompletionStage<Result> setMaintenance() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = request().body().asJson();
            Maintenance maintenance = mapper.readValue(jsonNode.toString(), Maintenance.class);
            maintenanceList.add(maintenance);
            resultCompletionStage = CompletableFuture.completedFuture(ok(Config.getInstance().getSuccessJson(maintenance)));
        } catch (Exception e) {
            resultCompletionStage = CompletableFuture.completedFuture(badRequest(Config.getInstance().getBadRequestJson()));
        }
        return resultCompletionStage;
    }

    public CompletionStage<Result> getMenu() {
        CompletionStage<Result> resultCompletionStage;
        List<Menu> menuList = new ArrayList<>();
        List<Menu> children = new ArrayList<>();
        List<AssetType> assetTypes = AssetType.find.all();
        menuList.add(getHeader());
        menuList.add(new Menu("Menu", true));
        if (assetTypes.size() == 0) {
            resultCompletionStage = CompletableFuture.completedFuture(notFound(Config.getInstance().getNotFoundJson("AssetType")));
            return resultCompletionStage;
        } else {
            for (AssetType assetType : assetTypes) {
                children.add(new Menu(assetType.name, "/pages/assets/" + assetType.name));
            }
            menuList.add(new Menu("Assets", "/pages/assets", "ion ion-ios-monitor", children));
            menuList.add(getMenuMaintenance());
            menuList.add(getMenuRAB());
            menuList.add(getMenuAkun());
            menuList.add(getMenuVendor());
            menuList.add(getMenuPRSPK());
            menuList.add(getMenuSPB());
            menuList.add(getMenuListrikPAM());
            menuList.add(getMenuReport());
            menuList.add(getMenuHapusAsset());
            resultCompletionStage = CompletableFuture.completedFuture(ok(Config.getInstance().getSuccessJson(menuList)));
            return resultCompletionStage;
        }
    }

    private Menu getHeader() {
        return new Menu("Dashboard", "/pages/dashboard", "ion ion-android-home", true);
    }

    private Menu getMenuReport() {
        List<Menu> child = new ArrayList<>();
        child.add(new Menu("Report Asset", "/pages/report/asset"));
        child.add(new Menu("Report Anggaran", "/pages/report/anggaran"));
        child.add(new Menu("Report Pekerjaan", "/pages/report/progress"));
        return new Menu("Report", "/pages/report", "ion ion-arrow-graph-up-right", child);
    }

    private Menu getMenuRAB() {
        List<Menu> child = new ArrayList<>();
        child.add(new Menu("List", "/pages/rab/list"));
        child.add(new Menu("Create", "/pages/rab/create"));
        child.add(new Menu("Draft", "/pages/rab/draft"));
        return new Menu("RAB", "/pages/rab", "ion ion-ios-paper", child);
    }

    private Menu getMenuPRSPK() {
        List<Menu> child = new ArrayList<>();
        child.add(new Menu("List", "/pages/prspk/list"));
        child.add(new Menu("Create", "/pages/prspk/create"));
        child.add(new Menu("Print", "/pages/prspk/print"));
        return new Menu("PR/SPK", "/pages/prspk", "ion ion-document-text", child);
    }

    private Menu getMenuListrikPAM() {
        List<Menu> child = new ArrayList<>();
        child.add(new Menu("List", "/pages/elecpam/list"));
        child.add(new Menu("Create", "/pages/elecpam/create"));
//        child.add(new Menu("Anomali", "/pages/elecpam/anomali"));
//        child.add(new Menu("Flat", "/pages/elecpam/flat"));
//        child.add(new Menu("Normal", "/pages/elecpam/normal"));
//        child.add(new Menu("Print", "/pages/elecpam/print"));
        return new Menu("Listrik dan PAM", "/pages/elecpam", "ion ion-ios-lightbulb", child);
    }

    private Menu getMenuHapusAsset() {
        List<Menu> child = new ArrayList<>();
        child.add(new Menu("List", "/pages/deleted/list"));
//        child.add(new Menu("Print", "/pages/deleted/print"));
        return new Menu("Daftar Penghapusan Aset", "/pages/deleted", "ion ion-ios-trash", child);
    }

    private Menu getMenuMaintenance() {
        List<Menu> child = new ArrayList<>();
        child.add(new Menu("List", "/pages/maintenance/list"));
        child.add(new Menu("Create", "/pages/maintenance/create"));
        return new Menu("Maintenance", "/pages/maintenance", "ion ion-settings", child);
    }

    private Menu getMenuSPB() {
        List<Menu> child = new ArrayList<>();
        child.add(new Menu("List", "/pages/spb/list"));
        child.add(new Menu("Create", "/pages/spb/create"));
        return new Menu("SPB", "/pages/spb", "ion ion-ios-bookmarks", child);
    }

    private Menu getMenuAkun() {
        List<Menu> child = new ArrayList<>();
        child.add(new Menu("List", "/pages/akun/list"));
        child.add(new Menu("Create", "/pages/akun/create"));
//        child.add(new Menu("Print", "/pages/akun/print"));
        return new Menu("Akun", "pages/akun", "ion ion-ios-list", child);
    }

    private Menu getMenuVendor() {
        List<Menu> child = new ArrayList<>();
        child.add(new Menu("List", "/pages/vendor/list"));
        child.add(new Menu("Create", "/pages/vendor/create"));
//        child.add(new Menu("Print", "/pages/akun/print"));
        return new Menu("Vendor", "pages/vendor", "ion ion-android-contacts", child);
    }

}
