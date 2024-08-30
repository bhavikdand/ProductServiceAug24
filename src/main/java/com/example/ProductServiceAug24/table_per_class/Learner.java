package com.example.ProductServiceAug24.table_per_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="tpc_learners")
public class Learner extends User {
    private String college;
    private String company;
}
