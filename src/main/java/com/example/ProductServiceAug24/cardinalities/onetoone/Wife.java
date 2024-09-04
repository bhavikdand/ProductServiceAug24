package com.example.ProductServiceAug24.cardinalities.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "wi")
public class Wife {
    @Id
    long id;
    String name;
    @OneToOne
    Husband h;
}
