package com.example.banktransactions.controller;

import com.example.banktransactions.entity.Balance;
import com.example.banktransactions.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create-account")
    public void createAccount(@RequestParam Long customerId, @RequestParam String country){
        accountService.createAccount(customerId, country);
    }

    @PostMapping("/open-currency-account")
    public Balance openNewCurrencyAccount(@RequestParam Long customerId, @RequestParam String currency){
        return accountService.openCurrencyAccount(currency,customerId);
    }
}
