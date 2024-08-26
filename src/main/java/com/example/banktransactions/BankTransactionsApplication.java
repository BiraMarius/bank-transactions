package com.example.banktransactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BankTransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankTransactionsApplication.class, args);
    }

}
