package com.partiw.api.domain.contribuitor;

import java.sql.Timestamp;
import java.util.UUID;

public record ContribuitorRequestDTO(String cpf,
                                     String name,
                                     String email,
                                     String phoneNumber,
                                     UUID companyId,
                                     Boolean hired,
                                     Timestamp dtBirth,
                                     String role,
                                     Timestamp dtAdmission,
                                     Timestamp dtInitVacation,
                                     UUID categoryId) {
}
