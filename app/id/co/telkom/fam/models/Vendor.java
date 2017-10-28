package id.co.telkom.fam.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.ebean.Finder;

import javax.persistence.*;

@Entity
@Table(name = "vendor")
@JsonPropertyOrder(value = {"id", "name", "address"}, alphabetic = true)
public class Vendor extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "vendor_pic")
    public String vendorPIC;

    @Column(name = "contact_vendor_pic")
    public String contactVendorPIC;

    @Column(name = "address")
    public String address;

    public static Finder<Long, Vendor> find = new Finder<>(Vendor.class);
}