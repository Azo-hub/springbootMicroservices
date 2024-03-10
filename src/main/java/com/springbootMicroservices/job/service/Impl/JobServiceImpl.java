package com.springbootMicroservices.job.service.Impl;

import com.springbootMicroservices.job.domain.Job;
import com.springbootMicroservices.job.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    List<Job> jobList = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobList;
    }

    @Override
    public void createJob(Job job) {
        jobList.add(job);
    }
}
