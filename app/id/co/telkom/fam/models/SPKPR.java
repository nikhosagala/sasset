package id.co.telkom.fam.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.telkom.fam.utils.Constants;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.SoftDelete;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "spk_pr")
public class SPKPR extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "tor_url")
    public String torUrl;

    @Column(name = "justification_url")
    public String justificationUrl;

    @Column(name = "document_url")
    public String documentUrl;

    @Column(name = "number")
    public String number;

    @Column(name = "document_date")
    public Date documentDate;

    @Column(name = "status")
    public String status;

    @Column(name = "type")
    public Integer type;

    @ManyToOne
    @JsonBackReference
    public RAB rab;

    @OneToMany(mappedBy = "spkpr", cascade = CascadeType.ALL)
    public List<SPB> spbList;

    public static Finder<Long, SPKPR> find = new Finder<>(SPKPR.class);
}