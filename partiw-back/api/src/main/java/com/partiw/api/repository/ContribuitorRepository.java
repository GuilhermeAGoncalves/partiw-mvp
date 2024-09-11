package com.partiw.api.repository;

import com.partiw.api.domain.contribuitor.Contribuitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ContribuitorRepository extends JpaRepository<Contribuitor, String> {

    @Query("SELECT c FROM Contribuitor c WHERE c.company.id = :companyId")
    List<Contribuitor> findByCompanyId(UUID companyId);
}
