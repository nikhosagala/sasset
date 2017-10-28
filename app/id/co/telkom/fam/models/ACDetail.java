package id.co.telkom.fam.models;

import io.ebean.Finder;

import javax.persistence.*;

@Entity
@Table(name = "ac_detail")
public class ACDetail extends BaseModel {
    public static Finder<Long, ACDetail> find = new Finder<>(ACDetail.class);
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Integer type;
    public Integer aircosaver;
    public Integer vrvvrf;
    public Asset asset;
}