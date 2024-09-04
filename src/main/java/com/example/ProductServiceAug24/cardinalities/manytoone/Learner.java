package com.example.ProductServiceAug24.cardinalities.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="learner_3")
public class Learner {
    @Id
    int id;

    String name;
    @ManyToOne()
    Batch b;

}
