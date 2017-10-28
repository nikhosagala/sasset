package id.co.telkom.fam.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.telkom.fam.utils.Constants;
import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "maintenance_detail")
public class MaintenanceDetail extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "maintenance_date")
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
    public Date maintenanceDate;

    @Column(name = "maintenance_document_url")
    public String maintenanceDocumentUrl;

    @Column(name = "maintenance_report")
    public String maintenanceReport;

    @Column(name = "status_asset")
    public Integer statusAsset;

    @ManyToOne
    public Maintenance maintenance;

    public static Finder<Long, MaintenanceDetail> find = new Finder<>(MaintenanceDetail.class);
}