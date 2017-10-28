package id.co.telkom.fam.models.json;

import id.co.telkom.fam.models.Asset;

import java.util.List;

public class AssetSummary {
    public Long id;
    public String treg;
    public String witel;
    public String office;
    public Integer quantity;
    public List<Asset> details;
}
