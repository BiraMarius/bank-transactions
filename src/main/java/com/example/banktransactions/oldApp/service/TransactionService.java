package com.example.banktransactions.oldApp.service;

import com.example.banktransactions.oldApp.dto.CreateTransactionDto;
import com.example.banktransactions.entity.*;
import com.example.banktransactions.oldApp.entity.Transaction;
import com.example.banktransactions.oldApp.exception.AccountEx;
import com.example.banktransactions.oldApp.exception.AmmountEx;
import com.example.banktransactions.oldApp.util.TransactionHelper;
import com.example.banktransactions.oldApp.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionService {
    private final TransactionHelper transactionHelper;
    private final AccountService accountService;
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionHelper transactionHelper, AccountService accountService, TransactionRepository transactionRepository) {
        this.transactionHelper = transactionHelper;
        this.accountService = accountService;
        this.transactionRepository = transactionRepository;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    public void createTransaction(CreateTransactionDto transaction) throws RuntimeException{

        if(!transactionHelper.isValidAmount(transaction.getAmount())){
            throw new AmmountEx("Amount not valid.");
        }

        if(!transactionHelper.isAccountValid(transaction.getAccountId())){
            throw new AccountEx("Account not valid.");
        }

        if(transactionHelper.isSameCurrencyTransaction(transaction.getAccountId(), transaction.getCurrency())){
            transactionHelper.isBalanceAvailable(transaction);
        }

        Transaction transactionComplete = new Transaction(accountService.getAccountById(transaction.getAccountId()), transaction.getAmount(), transaction.getCurrency(), transaction.getDirection(), transaction.getDescription());
        transactionRepository.save(transactionComplete);
    }




}
