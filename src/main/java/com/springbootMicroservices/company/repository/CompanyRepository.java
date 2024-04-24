package com.springbootMicroservices.company.repository;

import com.springbootMicroservices.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
