package id.openbox.sasset.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "floor")
    public int floor;

    @Column(name = "room_name")
    public String roomName;

    @ManyToOne
    @JsonBackReference
    public Office office;

    public static Finder<Long, Location> find = new Finder<>(Location.class);
}