package com.example.ProductServiceAug24.mapped_super_class;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

//@Setter
//@Getter
@Data
@MappedSuperclass
public class User {
    @Id
    private int id;
    private String name;
    private String password;
    private String email;

}


