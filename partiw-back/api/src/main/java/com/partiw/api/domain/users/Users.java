package com.partiw.api.domain.users;

import com.partiw.api.domain.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Table(name = "pw_user")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    private UUID userId;

    private String name;

    private String email;

    private String password;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
