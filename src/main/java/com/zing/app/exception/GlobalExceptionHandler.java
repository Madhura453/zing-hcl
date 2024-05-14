package com.zing.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientFundException.class)
    public ResponseEntity<Object> handleInsufficientFundException(InsufficientFundException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler(AccountDetailsNotFoundException.class)
    public ResponseEntity<Object> handleAccountDetailsNotFoundException(AccountDetailsNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
