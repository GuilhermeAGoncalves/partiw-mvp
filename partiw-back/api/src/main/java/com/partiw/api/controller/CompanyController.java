package com.partiw.api.controller;

import com.partiw.api.domain.company.Company;
import com.partiw.api.domain.company.CompanyRequestDTO;
import com.partiw.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> create(@RequestParam("name") String name,
                                          @RequestParam("active") Boolean active) {
        CompanyRequestDTO companyRequestDTO = new CompanyRequestDTO(name, active);
        Company newCompany = this.companyService.createCompany(companyRequestDTO);
        return ResponseEntity.ok(newCompany);
    }

    @GetMapping
    public ResponseEntity<Company> get(@RequestParam("companyId") UUID companyId) {
        Company company = this.companyService.getCompany(companyId);
        return ResponseEntity.ok(company);
    }
}
