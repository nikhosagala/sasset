package id.openbox.sasset.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "witel")
public class WITEL extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "gm_witel")
    public String GMWitel;

    @Column(name = "contact_gm_witel")
    public String contactGMWitel;

    @Column(name = "manager_logistic")
    public String managerLogistic;

    @Column(name = "contact_manager_logistic")
    public String contactManagerLogistic;

    @ManyToOne
    @JsonBackReference
    public TREG treg;

    @OneToMany(mappedBy = "witel", cascade = CascadeType.ALL)
    public List<Office> officeList;

    @ManyToOne
    @JsonBackReference
    public FMGSD fmGsd;

    public static Finder<Long, WITEL> find = new Finder<>(WITEL.class);
}
