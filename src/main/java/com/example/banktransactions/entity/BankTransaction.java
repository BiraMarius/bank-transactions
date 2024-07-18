package com.example.banktransactions.entity;

import com.example.banktransactions.entity.enums.CurrencyOf;
import com.example.banktransactions.entity.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BankTransaction {

    private Long id;

    private TransactionStatus transactionStatus;

    private String receiverIban;

    private Balance balance;

    private String senderIban;

    private LocalDate dateOfTransaction;

    private LocalDateTime successfulStatusTime;

    private BigDecimal valueOfBankTransaction;

    private CurrencyOf currency;

    private String description;//reason
}
