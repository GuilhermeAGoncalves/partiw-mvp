package com.partiw.api.domain.users;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public record UsersRequestDTO(String name, String email, UUID companyId, String password) {
}
