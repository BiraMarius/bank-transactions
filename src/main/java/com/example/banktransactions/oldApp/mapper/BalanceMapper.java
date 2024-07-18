package com.example.banktransactions.oldApp.mapper;

import com.example.banktransactions.oldApp.dto.BalanceDto;
import com.example.banktransactions.oldApp.entity.Balance;
import com.example.banktransactions.oldApp.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BalanceMapper {
    private final AccountService accountService;

    public BalanceDto entityToDto(Balance balance){
        return BalanceDto.builder()
                .accountId(balance.getAccount().getAccountId())
                .amount(balance.getAmount())
                .currency(balance.getCurrency())
                .build();
    }

    public Balance dtoToEntity(BalanceDto balanceDto){
        return Balance.builder()
                .account(accountService.getAccountById(balanceDto.getAccountId()))
                .amount(balanceDto.getAmount())
                .currency(balanceDto.getCurrency())
                .build();
    }

    public List<BalanceDto> listOfEntityToDto(List<Balance> balances){
        List<BalanceDto> balancesDto= new ArrayList<>();
        for(Balance balance : balances){
            balancesDto.add(entityToDto(balance));
        }
        return balancesDto;
    }

}
