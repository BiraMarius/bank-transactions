package com.example.banktransactions.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cardNumber;

    @Column
    private String CVV;

    @Column
    private String NameOnTheCard;

    @Column
    private LocalDate dateOfExpiration;

    @Column
    private LocalDateTime dateOfCreation;
}
