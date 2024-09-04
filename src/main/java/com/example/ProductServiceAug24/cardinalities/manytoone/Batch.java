package com.example.ProductServiceAug24.cardinalities.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name="batch_3")
public class Batch {

    String name;
    @Id
    long id;
    @OneToMany(mappedBy = "b")
    List<Learner> l;

}
