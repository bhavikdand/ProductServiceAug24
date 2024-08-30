package com.example.ProductServiceAug24.table_per_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="tpc_tas")
public class TA extends User {
    private int numOfQuestions;
    private String college;
}
