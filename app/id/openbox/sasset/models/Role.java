package id.openbox.sasset.models;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
}
