package com.example.banktransactions.dto;

import com.example.banktransactions.entity.Currency;
import com.example.banktransactions.entity.Direction;

import java.math.BigDecimal;

public class TransactionDto {
    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private Currency currency;
    private Direction direction;
    private String description;
    //    private Balance balance;
}
