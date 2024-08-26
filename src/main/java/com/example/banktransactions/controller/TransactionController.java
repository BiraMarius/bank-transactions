package com.example.banktransactions.controller;

import com.example.banktransactions.dto.CreateTransactionDto;
import com.example.banktransactions.entity.CurrencyRates;
import com.example.banktransactions.entity.Transaction;
import com.example.banktransactions.service.CurrencyExchangeService;

import com.example.banktransactions.service.TransactionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private final CurrencyExchangeService currencyExchangeService;
    private final TransactionService transactionService;

    public TransactionController(CurrencyExchangeService currencyExchangeService, TransactionService transactionService) {
        this.currencyExchangeService = currencyExchangeService;
        this.transactionService = transactionService;
    }

//    @PostMapping
//    public Transaction createTransaction(@Validated @RequestBody CreateTransactionDto createTransactionDto){
//        Transaction newTransaction = new Transaction();
//        newTransaction.setAccount(createTransactionDto.getAccountId());
//
//        //Transaction verify
//
//        //Transaction create
//
//    }

    @GetMapping("/get-message")
    public String ct(@RequestBody CreateTransactionDto createTransactionDto){
        return currencyExchangeService.verifyCurrency(currencyExchangeService.getCurrencyRatesFromApi(),createTransactionDto.getCurrency());
    }

    @GetMapping("/gettt")
    public CurrencyRates curr(){
        return currencyExchangeService.getCurrencyRatesFromApi();
    }

    @PostMapping("/create-transaction")
    public String createNewTransaction(@RequestBody CreateTransactionDto transactionDto){
        transactionService.createTransaction(transactionDto);
        return "Transaction complete.";
    }

}
