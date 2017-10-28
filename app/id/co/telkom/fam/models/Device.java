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