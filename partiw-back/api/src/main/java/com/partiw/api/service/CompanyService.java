package com.partiw.api.service;

import com.partiw.api.domain.company.Company;
import com.partiw.api.domain.company.CompanyRequestDTO;
import com.partiw.api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(CompanyRequestDTO company) {
        Company newCompany = new Company();
        newCompany.setName(company.name());
        newCompany.setActive(company.active());
        return companyRepository.save(newCompany);

    }

    public Company getCompany(UUID companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }
}
