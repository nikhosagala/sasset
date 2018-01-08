package id.openbox.sasset.models;

import io.ebean.Finder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fm_gsd")
public class FMGSD extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "contact")
    public String contact;

    @Column(name = "office_address")
    public String officeAddress;

    @Column(name = "operation_manager")
    public String operationManager;

    @Column(name = "contact_operation_manager")
    public String contactOperationManager;

    @OneToMany(mappedBy = "fmGsd", cascade = CascadeType.ALL)
    public List<WITEL> witelList;

    public Area area;

    public static Finder<Long, FMGSD> find = new Finder<>(FMGSD.class);
}