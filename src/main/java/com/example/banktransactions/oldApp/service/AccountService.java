package com.example.banktransactions.oldApp.service;

import com.example.banktransactions.entity.*;
import com.example.banktransactions.oldApp.entity.Client;
import com.example.banktransactions.oldApp.exception.AccountEx;
import com.example.banktransactions.oldApp.exception.CurrencyAccountExists;
import com.example.banktransactions.oldApp.entity.Account;
import com.example.banktransactions.oldApp.repository.ClientRepository;
import com.example.banktransactions.oldApp.repository.AccountRepository;
import com.example.banktransactions.oldApp.repository.BalanceRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

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

    @Transactional(propagation = Propagation.REQUIRED)
    public Account createAccount(Long clientId, String country) throws RuntimeException{
        Client client = clientService.clientFromOptional(clientId);
        if(client.getAccount() == null){
            Account account = new Account(client, country, new ArrayList<>(), new ArrayList<>());
            client.setAccount(account);
            accountRepository.save(account);
            clientRepository.save(client);
            return account;
        } else {
            throw new CurrencyAccountExists("An account for this client already exists!");
        }
    }

    public Account getAccountById(Long accountId) throws RuntimeException{
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        if(accountOpt.isPresent()){
            return accountOpt.get();
        } else {
            throw new AccountEx("Account not found.");
        }
    }



    public Optional<Account> getAccountOptional(Long accountId){
        return  accountRepository.findById(accountId);
    }

    //TODO TABEL AUDIT CLIENT(clientId), Actiune, Description("created account for id..")
}
