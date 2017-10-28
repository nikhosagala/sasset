package id.co.telkom.fam.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.telkom.fam.utils.Constants;
import io.ebean.Finder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "asset")
public class Asset extends BaseModel {
    public static Finder<Long, Asset> find = new Finder<>(Asset.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String function;
    public Double capacity;
    public String unit;
    public String merk;
    public String type;
    public String series;
    public Integer quantity;
    public Double unitPrice;
    public Double performance;
    @JsonFormat(pattern = Constants.YEAR_FORMAT, timezone = Constants.TIME_ZONE)
    public Date installationDate;
    public Integer usedYear;
    public String guaranteeNumber;
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
    public Date guaranteePeriod;
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
    public Date guaranteeExpireDate;
    public Integer statusAsset;
    public String description;
    @ManyToOne
    public AssetType assetType;
    @ManyToOne
    public Vendor vendor;
    @ManyToOne
    public Location location;
    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
    public List<Maintenance> maintenanceList;
}
