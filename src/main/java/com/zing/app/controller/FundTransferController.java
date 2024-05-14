package com.zing.app.controller;

import com.zing.app.model.FundTransferPayload;
import com.zing.app.model.TransactionDetails;
import com.zing.app.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class FundTransferController {

    @Autowired
    FundTransferService fundTransferService;

    @PostMapping("/fundtransfer")
    public ResponseEntity<TransactionDetails> createFundTransfer(@RequestBody FundTransferPayload fundTransferPayload) {
       TransactionDetails transaction = fundTransferService.createTransfer(fundTransferPayload);
        return ResponseEntity.ok(transaction);
    }
}
