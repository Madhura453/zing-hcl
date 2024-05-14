package com.zing.app.exception;

public class InsufficientFundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public InsufficientFundException(String message) {
        super(message);
    }
}