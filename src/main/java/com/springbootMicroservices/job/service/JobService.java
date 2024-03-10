package com.springbootMicroservices.job.service;

import com.springbootMicroservices.job.domain.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
}
