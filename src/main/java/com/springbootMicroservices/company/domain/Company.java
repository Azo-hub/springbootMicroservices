package com.springbootMicroservices.company.domain;

import com.springbootMicroservices.job.domain.Job;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @OneToMany
    private List<Job> jobs;

}
