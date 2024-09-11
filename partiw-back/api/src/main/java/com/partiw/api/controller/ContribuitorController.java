package com.partiw.api.controller;

import com.partiw.api.domain.company.CompanyRequestDTO;
import com.partiw.api.domain.contribuitor.Contribuitor;
import com.partiw.api.domain.contribuitor.ContribuitorRequestDTO;
import com.partiw.api.service.ContribuitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
    @RequestMapping("/api/contribuitor")
public class ContribuitorController {

    @Autowired
    private ContribuitorService contribuitorService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Contribuitor> create(@RequestBody Map<String, Object> payload) {
        // Extraindo dados do payload
        String cpf = (String) payload.get("cpf");
        String name = (String) payload.get("name");
        String email = (String) payload.get("email");
        Timestamp dtBirth = Timestamp.valueOf((String) payload.get("dtBirth")); // Assumindo que a data vem no formato ISO 8601
        String phoneNumber = (String) payload.get("phoneNumber");
        Boolean hired = (Boolean) payload.get("hired");
        String role = (String) payload.get("role");
        Timestamp dtAdmission = Timestamp.valueOf((String) payload.get("dtAdmission"));
        Timestamp dtInitVacation = Timestamp.valueOf((String) payload.get("dtVacation"));
        UUID companyId = UUID.fromString((String) payload.get("companyId"));
        UUID categoryId = UUID.fromString((String) payload.get("categoryId"));

        ContribuitorRequestDTO contribuitorRequestDTO = new ContribuitorRequestDTO(
                cpf, name, email,phoneNumber, companyId, hired, dtBirth, role, dtAdmission, dtInitVacation, categoryId
        );

        Contribuitor contribuitor = this.contribuitorService.createContribuitor(contribuitorRequestDTO);
        return ResponseEntity.ok(contribuitor);
    }

    @GetMapping
    public ResponseEntity<Contribuitor> get(@RequestParam("cpf") String cpf) {
        Contribuitor contribuitor = this.contribuitorService.getContribuitor(cpf);
        return ResponseEntity.ok(contribuitor);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/company")
    public ResponseEntity<List<Contribuitor>> getAll (@RequestParam("companyId") UUID companyId) {
        List<Contribuitor> contribuitor = this.contribuitorService.getAllContribuitors(companyId);
        return ResponseEntity.ok(contribuitor);
    }
}
