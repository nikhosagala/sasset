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
@Table(name = "office")
public class Office extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "address")
    public String address;

    @Column(name = "phone_number")
    public String phoneNumber;

    @ManyToOne
    @JsonBackReference
    public WITEL witel;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    public List<Location> locationList;

    @OneToOne
    public ElectricityPAM electricity;

    @OneToOne
    public ElectricityPAM pam;

    public static Finder<Long, Office> find = new Finder<>(Office.class);
}
