package com.example.banktransactions.controller;

import com.example.banktransactions.entity.Balance;
import com.example.banktransactions.entity.CurrencyRates;
import com.example.banktransactions.service.AccountService;
import com.example.banktransactions.service.CurrencyExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountService accountService;
    private final CurrencyExchangeService currencyExchangeService;

    public AccountController(AccountService accountService, CurrencyExchangeService currencyExchangeService) {
        this.accountService = accountService;
        this.currencyExchangeService = currencyExchangeService;
    }

    //TODO -2 Create validator https://docs.spring.io/spring-framework/reference/core/validation/validator.html for not null currency use CURRENCY enum
    @PostMapping("/create-account")
    public void createAccount(@RequestParam Long customerId, @RequestParam String country){
        accountService.createAccount(customerId, country);
    }

// OUT OF USE
//    @PostMapping("/open-currency-account")
//    public Balance openNewCurrencyAccount(@RequestParam Long customerId, @RequestParam String currency){
//        return accountService.openCurrencyAccount(currency,customerId);
//    }

    @GetMapping("/get-api-call")
    public CurrencyRates getJson(){
        return currencyExchangeService.getCurrencyRatesFromApi();
    }


    //TODO -4 AOP Audit
}
