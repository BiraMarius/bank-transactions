package com.example.banktransactions.util;

import com.example.banktransactions.dto.CreateTransactionDto;
import com.example.banktransactions.entity.*;
import com.example.banktransactions.exception.AmmountEx;
import com.example.banktransactions.exception.CurrencyDoesNotExists;
import com.example.banktransactions.repository.AccountRepository;
import com.example.banktransactions.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TransactionHelper {
    private final AccountService accountService;
    private final AccountRepository accountRepository;

    public boolean isValidAmount(BigDecimal amount){
        return (amount.compareTo(BigDecimal.ZERO) > 0);
    }

    public boolean isValidAccount(long accountId){
        Optional<Account> accountOptional = accountService.getAccountOptional(accountId);
        if(accountOptional.isPresent()){
            return true;
        }
        return false;
    }

    public boolean isAccountValid(Long accountId){
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        if(accountOpt.isPresent()){
            return true;
        }
        return false;
    }

    //This method check if in the client account exists a balance with same currency
    public boolean isSameCurrencyTransaction(Long clientId, Currency currency){
        Account account = accountService.getAccountById(clientId);
        List<Balance> balante= account.getBalances();
        for(Balance balance : balante){
            if(balance.getCurrency().equals(currency)){
                return true;
            }
        }
        return false;
    }

    //This method returns the balance object of the specific currency
    public Balance getCurrencyBalance(Long clientId, Currency currency) throws RuntimeException{
        Account account = accountService.getAccountById(clientId);
        List<Balance> accountBalances = account.getBalances();
        for(Balance balance : accountBalances){
            if(balance.getCurrency().equals(currency)){
                return balance;
            }
        }
        throw new CurrencyDoesNotExists("This account doesnt have this currency.");
    }

    //This method checks balance and make operations on it if it is available.
    public boolean isBalanceAvailable(CreateTransactionDto transaction) {
        Balance balance = getCurrencyBalance(transaction.getAccountId(), transaction.getCurrency());
        if(transaction.getDirection().equals(Direction.OUT)){
            if(balance.getAmount().compareTo(transaction.getAmount()) < 0){
                throw new AmmountEx("Amount is over balance limit.");
            }
            balance.setAmount(balance.getAmount().subtract(transaction.getAmount()));
        } else {
            balance.setAmount(balance.getAmount().add(transaction.getAmount()));
        }
        return true;
    }

//    public boolean isCurrencyValid(Currency currency){
//        if(currency.)
//    }


}
