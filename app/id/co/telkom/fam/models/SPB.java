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
@Table(name = "spb")
public class SPB extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "document_url")
    public String document_url;

    @Column(name = "status")
    public String status;

    @ManyToOne
    @JsonBackReference
    public SPKPR spkpr;

    public static Finder<Long, SPB> find = new Finder<>(SPB.class);
}