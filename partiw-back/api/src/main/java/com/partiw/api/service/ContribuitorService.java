package com.partiw.api.service;

import com.partiw.api.domain.category.Category;
import com.partiw.api.domain.company.Company;
import com.partiw.api.domain.contribuitor.Contribuitor;
import com.partiw.api.domain.contribuitor.ContribuitorRequestDTO;
import com.partiw.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContribuitorService {

    @Autowired
    private ContribuitorRepository contribuitorRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Contribuitor createContribuitor(ContribuitorRequestDTO contribuitor) {
        Company company = companyRepository.findById(contribuitor.companyId())
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        Category category = categoryRepository.findById(contribuitor.categoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        Contribuitor newContribuitor = new Contribuitor();

        newContribuitor.setName(contribuitor.name());
        newContribuitor.setCpf(contribuitor.cpf());
        newContribuitor.setEmail(contribuitor.email());
        newContribuitor.setDtBirth(contribuitor.dtBirth());
        newContribuitor.setPhoneNumber(contribuitor.phoneNumber());
        newContribuitor.setHired(contribuitor.hired());
        newContribuitor.setRole(contribuitor.role());
        newContribuitor.setDtAdmission(contribuitor.dtAdmission());
        newContribuitor.setDtInitVacation(contribuitor.dtInitVacation());
        newContribuitor.setCompany(company);
        newContribuitor.setCategory(category);
        return contribuitorRepository.save(newContribuitor);
    }

    public Contribuitor getContribuitor(String cpf) {
        return contribuitorRepository.findById(cpf).orElse(null);
    }

    public List<Contribuitor> getAllContribuitors(UUID companyId) {
        return contribuitorRepository.findByCompanyId(companyId);
    }
}
