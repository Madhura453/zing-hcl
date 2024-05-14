package com.zing.app.controller;

import com.zing.app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private AccountService accountService;
    private AccountController(AccountService accountService)
    {
        this.accountService=accountService;
    }

    @GetMapping("/account")
    public ResponseEntity<?> getAccountDetails(@RequestParam("customerId") Long customerId) {
        return new ResponseEntity<>(accountService.getAccountDetails(customerId), HttpStatus.OK);
    }

    @GetMapping("/account-transaction-details")
    public ResponseEntity<?>  getAccountSummary(@RequestParam("customerId") Long customerId)
    {
     return new ResponseEntity<>(accountService.getAccountSummary(customerId), HttpStatus.OK);
    }
}
