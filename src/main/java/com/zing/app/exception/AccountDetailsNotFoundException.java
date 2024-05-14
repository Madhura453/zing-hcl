package com.zing.app.exception;

import org.springframework.http.HttpStatus;

public class AccountDetailsNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    final Integer errorCode;
    final HttpStatus httpErrorCode;
    public AccountDetailsNotFoundException(Integer errorCode, String errorMessage, HttpStatus httpErrorCode) {
        super(errorMessage);
        this.errorCode=errorCode;
        this.httpErrorCode = httpErrorCode;
    }
}