package com.springbootMicroservices.company.controller;

import com.springbootMicroservices.company.domain.Company;
import com.springbootMicroservices.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {

        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.createCompany(company), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        return new ResponseEntity<>(companyService.updateCompany(id,company), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable("id") Long id) {
        boolean deleted = companyService.deleteCompanyById(id);
        if (deleted) {
            return new ResponseEntity<>("delete successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("delete unsuccessful", HttpStatus.NOT_IMPLEMENTED);

    }
}
