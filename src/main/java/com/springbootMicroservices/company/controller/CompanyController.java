package com.springbootMicroservices.company.controller;

import com.springbootMicroservices.company.domain.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @GetMapping
    public ResponseEntity<Company> getAllCompanies() {

        return new ResponseEntity<>(new Company(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {

        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {

        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(new Company(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable("id") Long id) {

        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }
}
