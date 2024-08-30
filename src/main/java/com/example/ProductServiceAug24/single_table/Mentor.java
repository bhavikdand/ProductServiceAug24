package com.example.ProductServiceAug24.single_table;

import lombok.Data;

@Data
public class Mentor extends User {
    private double avg_rating;
    private String currentCompany;
}
