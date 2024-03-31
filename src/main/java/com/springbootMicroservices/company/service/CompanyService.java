package com.springbootMicroservices.company.service;

import com.springbootMicroservices.company.domain.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company createCompany(Company company);

    Company updateCompany(Long id, Company company);

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);
}
