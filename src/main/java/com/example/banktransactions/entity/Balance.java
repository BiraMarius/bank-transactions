package com.example.banktransactions.entity;

import com.example.banktransactions.oldApp.entity.Currency;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class Balance {

    private Long id;

    private Currency currency;

    private BigDecimal balanceValue;

    private LocalDateTime dateOfOpening;

    private Set<BankTransaction> bankTransactionList;


}
