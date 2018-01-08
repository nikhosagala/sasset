package id.openbox.sasset.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;

import javax.persistence.*;

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