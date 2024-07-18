package com.example.banktransactions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userCode;

//    @Column
//    private String authorizationCode;

    @Column
    private String password;

    @OneToMany
    private Set<BankAccount> accounts;

}
