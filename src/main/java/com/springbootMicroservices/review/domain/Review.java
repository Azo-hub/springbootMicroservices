package com.springbootMicroservices.review.domain;

import com.springbootMicroservices.company.domain.Company;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private double rating;

    @ManyToOne
    private Company company;
}
