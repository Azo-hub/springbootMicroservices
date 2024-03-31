package com.springbootMicroservices.company.service.impl;

import com.springbootMicroservices.company.domain.Company;
import com.springbootMicroservices.company.repository.CompanyRepository;
import com.springbootMicroservices.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        Optional<Company> dbCompany = companyRepository.findById(id);
        dbCompany.ifPresent(c -> {
            c.setName(company.getName());
            c.setDescription(company.getDescription());
            c.setJobs(company.getJobs());

            companyRepository.save(c);

        });

        return dbCompany.orElse(null);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try{
            companyRepository.deleteById(id);
            return true;
        } catch (RuntimeException e){
            return false;
        }


    }
}
