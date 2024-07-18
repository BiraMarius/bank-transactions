package com.example.banktransactions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private BusinessAccCustomer businessAccCustomer;

    @OneToOne
    private PersonalAccCustomer personalAccCustomer;

    @OneToMany
    private Set<UserAccountCredentials> users;

}
