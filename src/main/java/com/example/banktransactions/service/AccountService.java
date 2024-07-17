package com.example.banktransactions.service;

import com.example.banktransactions.entity.*;
import com.example.banktransactions.exception.CurrencyAccountExists;
import com.example.banktransactions.exception.CurrencyDoesNotExists;
import com.example.banktransactions.repository.AccountRepository;
import com.example.banktransactions.repository.BalanceRepository;
import com.example.banktransactions.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final BalanceRepository balanceRepository;

    public AccountService(ClientService clientService, ClientRepository clientRepository, AccountRepository accountRepository, BalanceRepository balanceRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.balanceRepository = balanceRepository;
    }

    public Balance openCurrencyAccount(String currency, Long clientId) throws RuntimeException{
        Client client = clientService.clientFromOptional(clientId);
        List<Balance> balances = client.getAccount().getBalances();
        if(balances.isEmpty()){
            return createNewBalance(currency, client);
        } else {
            doesBalanceExists(currency, balances);
        }
        throw new CurrencyAccountExists("ERROR");
    }

    private void doesBalanceExists(String currency, List<Balance> balances) throws RuntimeException{
        for(Balance balance : balances){
            if(balance.getCurrency().name().equalsIgnoreCase(currency)){
                throw new CurrencyAccountExists("You already have an account with your desired currency. Please check \"Balances\"");
            }
        }
    }

    private Balance createNewBalance(String currency, Client client) throws RuntimeException{
        for(Currency currency1 : Currency.values()){
            if(currency1.name().equalsIgnoreCase(currency)){
                Balance balance = new Balance(client.getAccount(), BigDecimal.valueOf(0));
                balance.setCurrency(currency1);
                client.getAccount().getBalances().add(balance);
                balanceRepository.save(balance);
                clientRepository.save(client);
                return balance;
            }
        }
        throw new CurrencyDoesNotExists("Your desired currency doesn't exists. Please enter a valid one.");
    }

//    public boolean accountExists(String currency, Long clientId) throws RuntimeException{
//        Client client = clientService.clientFromOptional(clientId);
//        Account account = client.getAccount();
//        List<Balance> balances = client.getAccount().getBalances();
//        for(Balance balance : balances){
//            if(balance.getCurrency().name().equalsIgnoreCase(currency)){
//                return true;
//                //throw new CurrencyAccountExists("An account with this type of currency already exists!");
//            }
//        }
//        return false;
//    }

    public Account createAccount(Long clientId, String country) throws RuntimeException{
        Client client = clientService.clientFromOptional(clientId);
        if(client.getAccount() == null){
            Account account = new Account(client, country, new ArrayList<Balance>(), new ArrayList<Transaction>());
            client.setAccount(account);
            accountRepository.save(account);
            clientRepository.save(client);
            return account;
        } else {
            throw new CurrencyAccountExists("An account for this client already exists!");
        }
    }
}
