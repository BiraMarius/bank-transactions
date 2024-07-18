package com.example.banktransactions.oldApp.dto;

import com.example.banktransactions.oldApp.entity.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BalanceDto {
    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private Currency currency;
}
