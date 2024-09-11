package com.partiw.api.service;

import com.partiw.api.domain.company.Company;
import com.partiw.api.domain.users.Users;
import com.partiw.api.domain.users.UsersRequestDTO;
import com.partiw.api.repository.CompanyRepository;
import com.partiw.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Users createUser(UsersRequestDTO user) {
        Company company = companyRepository.findById(user.companyId())
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));
        Users newUser = new Users();

        newUser.setName(user.name());
        newUser.setEmail(user.email());
        newUser.setName(user.name());
        newUser.setPassword(user.password());
        newUser.setCompany(company);
        newUser.setCreatedAt(new java.sql.Timestamp(new java.util.Date().getTime()));
        newUser.setUpdatedAt(new java.sql.Timestamp(new java.util.Date().getTime()));
        newUser.setActive(true);

        return usersRepository.save(newUser);
    }

    public Users getUser(UUID userId) {
        return usersRepository.findById(userId).orElse(null);
    }

    public Users login(String email, String password) {
        return usersRepository.findByEmailAndPassword(email, password);
    }
}
