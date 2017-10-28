package id.co.telkom.fam.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.ebean.Finder;

import javax.persistence.*;

@Entity
@Table(name = "asset_type")
@JsonPropertyOrder(value = {"id", "name"}, alphabetic = true)
public class AssetType extends BaseModel {
    public static Finder<Long, AssetType> find = new Finder<>(AssetType.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
}
