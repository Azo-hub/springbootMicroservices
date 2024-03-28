package com.springbootMicroservices.job.service;

import com.springbootMicroservices.job.domain.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJob(Long id);

    Job updateJob(Long id, Job job);
}
