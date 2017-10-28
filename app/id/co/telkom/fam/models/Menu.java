package id.co.telkom.fam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;
    public String title;
    public String link;
    public String url;
    public String icon;
    @Transient
    public List<Menu> children;
    @JsonProperty("home")
    public boolean isHome;
    @JsonProperty("group")
    public boolean isGroup;
    @JsonIgnore
    public int parent;
}
