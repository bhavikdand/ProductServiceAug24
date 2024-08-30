package com.example.ProductServiceAug24.table_per_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="tpc_mentors")
public class Mentor extends User {
    private double avg_rating;
    private String currentCompany;
}
