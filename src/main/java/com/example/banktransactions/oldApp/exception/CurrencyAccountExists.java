package com.example.banktransactions.oldApp.exception;

public class CurrencyAccountExists extends RuntimeException{
    public CurrencyAccountExists(String message) {
        super(message);
    }
}
