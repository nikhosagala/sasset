package id.openbox.sasset.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "status")
    public Integer status;

    @ManyToOne
    @JsonBackReference
    public WITEL witel;

    @OneToOne
    public ElectricityPAM electricityPAM;

    public static Finder<Long, Device> find = new Finder<>(Device.class);
}