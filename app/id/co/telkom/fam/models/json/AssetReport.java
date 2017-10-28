package id.co.telkom.fam.models.json;

import id.co.telkom.fam.models.AssetType;
import id.co.telkom.fam.models.Office;
import id.co.telkom.fam.models.TREG;
import id.co.telkom.fam.models.WITEL;

import java.util.Date;

public class AssetReport {
    public TREG treg;
    public WITEL witel;
    public Office office;
    public AssetType assetType;
    public Date date;
    public String printedBy;
    public String function;
    public Integer totalAsset;
    public Integer runningNormal;
    public Integer underMaintenance;
    public Integer off;
    public Integer notMaintenance;
}
