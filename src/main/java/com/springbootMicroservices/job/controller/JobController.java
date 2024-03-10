package com.springbootMicroservices.job.controller;

import com.springbootMicroservices.job.domain.Job;
import com.springbootMicroservices.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/job")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping("/job")
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job created Successfully";
    }
}
