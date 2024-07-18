package com.example.banktransactions.oldApp.service;

import com.example.banktransactions.oldApp.dto.BalanceDto;
import com.example.banktransactions.oldApp.entity.Account;
import com.example.banktransactions.oldApp.entity.Balance;
import com.example.banktransactions.oldApp.entity.Client;
import com.example.banktransactions.oldApp.entity.Currency;
import com.example.banktransactions.oldApp.exception.AccountEx;
import com.example.banktransactions.oldApp.exception.CurrencyAccountExists;
import com.example.banktransactions.oldApp.exception.CurrencyDoesNotExists;
import com.example.banktransactions.oldApp.mapper.BalanceMapper;
import com.example.banktransactions.oldApp.repository.BalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class BalanceService {
    private final ClientService clientService;
    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;


   //This method check if client account exists, and search through the balances for desired currency
    @Transactional
    public Balance openCurrency2(String currency, Long clientId) throws RuntimeException{
        Client client = clientService.clientFromOptional(clientId);
        Currency currencyObject = findCurrency(currency);
        if(client.getAccount() != null){
            List<Balance> balances = client.getAccount().getBalances();
            if(balances.isEmpty()){
                return createNewBalance2(currencyObject, client.getAccount());
            } else {
                doesBalanceExists2(currencyObject, client.getAccount());
            }
        }
        throw new CurrencyAccountExists("Account doesn't exists.");
    }

    //Search currency in Currency enum based on a string
    public Currency findCurrency(String currency) throws RuntimeException{
        for(Currency availableCurrency : Currency.values()){
            if(currency.equalsIgnoreCase(availableCurrency.name())){
                return availableCurrency;
            }
        }
        throw new CurrencyDoesNotExists("Your desired currency doesn't exists. Please enter a valid one.");
    }

    //Check if the desired currency balance exists
    private Balance doesBalanceExists2(Currency currency, Account account) throws RuntimeException{
        for(Balance balance : account.getBalances()){
            if(balance.getCurrency().equals(currency)){
                throw new CurrencyAccountExists("You already have an account with your desired currency. Please check \"Balances\"");
            }
        }
        return createNewBalance2(currency, account);
    }

    //Create new balance with desired currency
    @Transactional
    protected Balance createNewBalance2(Currency currency, Account account) throws RuntimeException{
                Balance balance = new Balance(account, BigDecimal.valueOf(0));
                balance.setCurrency(currency);
                account.getBalances().add(balance);
                balanceRepository.save(balance);
                //clientRepository.save(client);
                return balance;
    }

    //This method get all balances from an account based on clientId
    public List<BalanceDto> getAllBalances(Long clientId){
        Client client = clientService.clientFromOptional(clientId);
        if(client.getAccount().getBalances().isEmpty()){
            throw new AccountEx("This account doesn't have any balances.");
        }
        return balanceMapper.listOfEntityToDto(client.getAccount().getBalances());
    }

}
