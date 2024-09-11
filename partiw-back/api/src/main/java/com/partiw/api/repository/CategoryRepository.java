package com.partiw.api.repository;

import com.partiw.api.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("SELECT c FROM Category c WHERE c.company.id = :companyId")
    List<Category> findByCompanyId(UUID companyId);
}
