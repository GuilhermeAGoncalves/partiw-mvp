package com.partiw.api.domain.category;

import com.partiw.api.domain.company.Company;

import java.util.UUID;

public record CategoryRequestDTO(String name, Integer valueMax, Integer coParticipation, UUID companyId) {
}
