package com.example.banktransactions.oldApp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.banktransactions.oldApp.entity.Currency;
import com.example.banktransactions.oldApp.entity.Direction;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTransactionDto {
    @NotNull(message = "Account id should not be null")
    @Positive(message = "Account Id should be more than 0")
    Long accountId;
    @Positive(message = "Amount should be more than 0.00")
    BigDecimal amount;
    @NotNull(message = "Currency should be selected")
    Currency currency;
    @NotNull(message = "Direction of the transaction should be selected")
    Direction direction;
    String description;
}
