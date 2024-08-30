package com.example.ProductServiceAug24.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@PrimaryKeyJoinColumn(name = "user_id")
@Entity(name = "jt_tas")
public class TA extends User {
    private int numOfQuestions;
    private String college;
}
