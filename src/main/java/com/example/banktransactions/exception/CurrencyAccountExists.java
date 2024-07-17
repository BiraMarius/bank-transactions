package com.example.banktransactions.exception;

public class CurrencyAccountExists extends RuntimeException{
    public CurrencyAccountExists(String message) {
        super(message);
    }
}
