package com.springbootMicroservices.job.controller;

import com.springbootMicroservices.job.domain.Job;
import com.springbootMicroservices.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity <List<Job>> findAll() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity <Job> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(jobService.getJobById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long id) {
        boolean deleted = jobService.deleteJob(id);
        if(deleted)
            return new ResponseEntity<>("Deleted", HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable("id") Long id, @RequestBody Job job) {
        Job updatedJob = jobService.updateJob(id, job);
        if(updatedJob != null)
            return new ResponseEntity<>(updatedJob, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
