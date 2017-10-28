package id.co.telkom.fam.models;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
}
