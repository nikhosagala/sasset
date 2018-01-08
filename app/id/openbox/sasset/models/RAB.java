package id.openbox.sasset.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fam_evaluation")
public class RAB extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "fam_evaluation")
    public boolean famEvaluation;

    @Column(name = "fam_evaluation_document_url")
    public String famEvaluationDocumentUrl;

    @Column(name = "fam_evaluation_price")
    public Double famEvaluationPrice;

    @ManyToOne
    @JsonBackReference
    public ProgressDetail progressDetail;

    @OneToMany(mappedBy = "rab", cascade = CascadeType.ALL)
    public List<SPKPR> spkprList;

    public static Finder<Long, RAB> find = new Finder<>(RAB.class);
}