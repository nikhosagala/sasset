package id.openbox.sasset.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import id.openbox.sasset.utils.Constants;
import io.ebean.Finder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "survey_location")
public class SurveyLocation extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "survey_date")
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
    public Date surveyDate;

    @Column(name = "survey_report")
    public String surveyReport;

    @Column(name = "survey_report_document_url")
    public String surveyReportDocumentUrl;

    @ManyToOne
    @JsonBackReference
    public ProgressDetail progressDetail;

    public Office office;

    public static Finder<Long, SurveyLocation> find = new Finder<>(SurveyLocation.class);
}