package com.partiw.api.domain.category;

import com.partiw.api.domain.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "pw_category")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private UUID categoryId;

    private String name;

    private Integer valueMax;

    private Integer coParticipation;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
