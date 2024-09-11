package com.partiw.api.domain.contribuitor;

import com.partiw.api.domain.category.Category;
import com.partiw.api.domain.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Table(name = "pw_contribuitor")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contribuitor {

    @Id
    private String cpf;

    private String name;

    private String email;

    private String phoneNumber;

    private Boolean hired;

    private Timestamp dtBirth;

    private String role;

    private Timestamp dtAdmission;

    private Timestamp dtInitVacation;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
