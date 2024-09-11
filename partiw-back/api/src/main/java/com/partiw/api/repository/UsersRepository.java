package com.partiw.api.repository;

import com.partiw.api.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {

    @Query("SELECT u FROM Users u WHERE u.email = :email AND u.password = :password")
    Users findByEmailAndPassword(String email, String password);
}
