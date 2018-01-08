package id.openbox.sasset.models;

import io.ebean.Finder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "electricity_pam")
public class ElectricityPAM extends BaseModel {
    @Id
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "address")
    public String address;

    @Column(name = "status")
    public Integer status;

    @OneToMany(mappedBy = "electricityPAM", cascade = CascadeType.ALL)
    public List<ElectricityPAMDetail> electricityPAMDetailList;

    public static Finder<Long, ElectricityPAM> find = new Finder<>(ElectricityPAM.class);
}