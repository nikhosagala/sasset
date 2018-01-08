package id.openbox.sasset.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;

import javax.persistence.*;

@Entity
@Table(name = "area")
public class Area extends BaseModel {
    public static Finder<Long, Area> find = new Finder<>(Area.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;

    @ManyToOne
    @JsonBackReference
    public WITEL witel;
}