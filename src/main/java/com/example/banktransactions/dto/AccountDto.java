package com.example.banktransactions.dto;

import com.example.banktransactions.entity.Balance;

import java.util.LinkedList;
import java.util.List;

public class AccountDto {
    private Long accountId;
    private String customerId;
    private String country;
//    private Set<Currency> currencies;
    private List<Balance> balances = new LinkedList<>();
}
