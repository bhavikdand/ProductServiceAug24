package com.example.ProductServiceAug24.cardinalities.manytomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Course {
    @Id
    private int id;
    private String name;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
