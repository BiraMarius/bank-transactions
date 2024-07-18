package com.example.banktransactions.oldApp.dto;

import com.example.banktransactions.oldApp.entity.Currency;
import com.example.banktransactions.oldApp.entity.Direction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {
    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private Currency currency;
    private Direction direction;
    private String description;
    //    private Balance balance;
}
