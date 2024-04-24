package com.springbootMicroservices.job.domain;

import com.springbootMicroservices.company.domain.Company;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    @ManyToOne
    private Company company;
}
