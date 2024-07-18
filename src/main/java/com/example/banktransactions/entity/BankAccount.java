package com.example.banktransactions.entity;

import com.example.banktransactions.entity.enums.StatusOfAccount;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserAccountCredentials userAccountCredentials;

    @Column
    private StatusOfAccount statusOfAccount;

    @Column
    private String iban;



}
