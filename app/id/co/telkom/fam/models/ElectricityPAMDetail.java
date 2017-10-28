package id.co.telkom.fam.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.telkom.fam.utils.Constants;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.SoftDelete;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "electricity_pam_detail")
public class ElectricityPAMDetail extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "period")
    @JsonFormat(pattern = Constants.MONTH_YEAR_FORMAT, timezone = Constants.TIME_ZONE)
    public Date period;

    @Column(name = "rate")
    public String rate;

    @Column(name = "power")
    public Double power;

    @Column(name = "start_total")
    public Double startTotal;

    @Column(name = "end_total")
    public Double endTotal;

    @Column(name = "used")
    public Double used;

    @Column(name = "price")
    public Double price;

    @ManyToOne
    @JsonBackReference
    public ElectricityPAM electricityPAM;

    public static Finder<Long, ElectricityPAMDetail> find = new Finder<>(ElectricityPAMDetail.class);
}