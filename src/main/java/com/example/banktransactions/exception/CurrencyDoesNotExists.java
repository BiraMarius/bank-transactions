package com.example.banktransactions.exception;

public class CurrencyDoesNotExists extends RuntimeException{
    public CurrencyDoesNotExists(String message) {
        super(message);
    }
}
