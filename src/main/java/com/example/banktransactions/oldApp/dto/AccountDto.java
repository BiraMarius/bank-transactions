package com.example.banktransactions.oldApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private Long accountId;
    private String customerId;
    private String country;
//    private Set<Currency> currencies;
    private List<BalanceDto> balances = new LinkedList<>();
}
