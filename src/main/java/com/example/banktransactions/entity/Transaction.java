package com.example.banktransactions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name="Transaction")
@Table(name="transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="accountId")
    private Account senderAccountId;

    @Column
    private BigDecimal amount;

    @Column
    private Currency currency;

    @Column
    private Direction direction;

    @Column
    private String description;

//    @Column
//    private Balance balance;

}
