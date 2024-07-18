package com.example.banktransactions.oldApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
    private Long clientId;
    private AccountDto account;
    private String name;
}
