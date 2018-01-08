package id.openbox.sasset.models;

import io.ebean.Finder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "treg")
public class TREG extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @OneToMany(mappedBy = "treg", cascade = CascadeType.ALL)
    public List<WITEL> witelList;

    public static Finder<Long, TREG> find = new Finder<>(TREG.class);
}
