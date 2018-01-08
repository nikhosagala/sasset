package id.openbox.sasset.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.openbox.sasset.utils.Constants;
import io.ebean.Finder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "status_asset_detail")
public class StatusAssetDetail extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "repairing_type")
    public String repairingType;

    @Column(name = "repairing_date")
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
    public Date repairingDate;

    @Column(name = "offering_price")
    public Double offeringPrice;

    @Column(name = "offering_document_url")
    public String offeringDocumentUrl;

    @ManyToOne
    public WITEL witel;

    @ManyToOne
    public Vendor vendor;

    public static Finder<Long, StatusAssetDetail> find = new Finder<>(StatusAssetDetail.class);
}