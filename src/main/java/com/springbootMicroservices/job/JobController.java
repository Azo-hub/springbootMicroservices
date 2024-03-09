package com.springbootMicroservices.job;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    @GetMapping
    public ResponseEntity<List<Job>> findAll() {

        return new ResponseEntity<>(new ArrayList<Job>(), HttpStatus.OK);
    }
}
