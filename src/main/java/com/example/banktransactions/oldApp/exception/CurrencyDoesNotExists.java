package com.example.banktransactions.oldApp.exception;

public class CurrencyDoesNotExists extends RuntimeException{
    public CurrencyDoesNotExists(String message) {
        super(message);
    }
}
