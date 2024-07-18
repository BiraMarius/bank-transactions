package com.example.banktransactions.entity;

import com.example.banktransactions.entity.enums.CurrencyOf;
import com.example.banktransactions.entity.enums.DirectionOfTransaction;
import com.example.banktransactions.entity.enums.TransactionStatus;

import java.math.BigDecimal;

public class HistoryOfTransaction {
    private Long id;

    private Balance balance;

    private TransactionStatus transactionStatus;

    private DirectionOfTransaction directionOfTransaction;

    private BigDecimal value;

    private CurrencyOf currency;

    private String description;

    private String senderIban;

    private String receiverIban;


}
