package com.example.ProductServiceAug24.table_per_class;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

//@Setter
//@Getter
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name="tpc_users")
public class User {
    @Id
    private int id;
    private String name;
    private String password;
    private String email;

}


