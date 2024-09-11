package com.partiw.api.service;

import com.partiw.api.domain.category.Category;
import com.partiw.api.domain.category.CategoryRequestDTO;
import com.partiw.api.domain.company.Company;
import com.partiw.api.repository.CategoryRepository;
import com.partiw.api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Category createCategory(CategoryRequestDTO category) {
        Company company = companyRepository.findById(category.companyId())
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        Category newCategory = new Category();
        newCategory.setName(category.name());
        newCategory.setValueMax(category.valueMax());
        newCategory.setCoParticipation(category.coParticipation());
        newCategory.setCompany(company);

        return categoryRepository.save(newCategory);
    }

    public Category getCategory(UUID categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public List<Category> getCategoryByCompany(UUID companyId) {
        return categoryRepository.findByCompanyId(companyId);
    }
}
