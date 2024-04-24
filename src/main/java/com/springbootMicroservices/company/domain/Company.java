package com.springbootMicroservices.company.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springbootMicroservices.job.domain.Job;
import com.springbootMicroservices.review.domain.Review;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<Job> jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<Review> review;

}
