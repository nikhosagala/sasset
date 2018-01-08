package id.openbox.sasset.models.json;

import id.openbox.sasset.models.Asset;

import java.util.List;

public class AssetSummary {
    public Long id;
    public String treg;
    public String witel;
    public String office;
    public Integer quantity;
    public List<Asset> details;
}
