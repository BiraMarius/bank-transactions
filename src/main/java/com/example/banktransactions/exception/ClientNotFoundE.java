package com.example.banktransactions.exception;

public class ClientNotFoundE extends RuntimeException{
    public ClientNotFoundE(String message) {
        super(message);
    }
}
