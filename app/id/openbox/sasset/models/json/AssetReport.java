package id.openbox.sasset.models.json;

import id.openbox.sasset.models.AssetType;
import id.openbox.sasset.models.Office;
import id.openbox.sasset.models.TREG;
import id.openbox.sasset.models.WITEL;

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
