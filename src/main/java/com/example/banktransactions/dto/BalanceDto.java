package com.example.banktransactions.dto;

import com.example.banktransactions.entity.Currency;

import java.math.BigDecimal;

public class BalanceDto {
    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private Currency currency;
}
