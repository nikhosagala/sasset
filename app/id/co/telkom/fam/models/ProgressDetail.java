package id.co.telkom.fam.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.telkom.fam.utils.Constants;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.SoftDelete;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "progress_detail")
public class ProgressDetail extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "survey_location")
    public String surveyLocation;

    @Column(name = "reoffering")
    public boolean reoffering;

    @Column(name = "reoffering_document_url")
    public String reofferingDocumentUrl;

    @Column(name = "reoffering_date")
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
    public Date reofferingDate;

    @Column(name = "reoffering_price")
    public Double reofferingPrice;

    @Column(name = "budget_type")
    public Integer budgetType;

    @Column(name = "progress_status")
    public String progressStatus;

    @OneToMany(mappedBy = "progressDetail", cascade = CascadeType.ALL)
    public List<SurveyLocation> surveyLocationList;

    @OneToMany(mappedBy = "progressDetail", cascade = CascadeType.ALL)
    public List<RAB> rabList;

    public StatusAssetDetail statusAssetDetail;

    public static Finder<Long, ProgressDetail> find = new Finder<>(ProgressDetail.class);
}