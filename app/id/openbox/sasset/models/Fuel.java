package id.openbox.sasset.models;

import io.ebean.Finder;

import javax.persistence.*;

@Entity
@Table(name = "fuel")
public class Fuel extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "capacity")
    public Double capacity;

    @Column(name = "stock")
    public Double stock;

    @Column(name = "status")
    public String status;

    public Office office;

    public static Finder<Long, Fuel> find = new Finder<>(Fuel.class);
}