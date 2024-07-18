package com.example.banktransactions.oldApp.controller;

import com.example.banktransactions.oldApp.dto.BalanceDto;
import com.example.banktransactions.oldApp.service.BalanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @PostMapping("/open-currency-balance")
    public void openCurrencyBalance(@RequestParam Long accountId, @RequestParam String currency){
        balanceService.openCurrency2(currency,accountId);
    }

    @GetMapping("/get-balances")
    public List<BalanceDto> getAllBalances(@RequestParam Long clientId){
        return balanceService.getAllBalances(clientId);
    }

}
