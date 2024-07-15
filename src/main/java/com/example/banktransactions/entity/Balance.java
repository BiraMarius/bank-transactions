package com.example.banktransactions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name="balance")
@Table(name="balance")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="accountId")
    private Account account;

    @Column
    private BigDecimal amount;

    @Column
    private Currency currency;

}
