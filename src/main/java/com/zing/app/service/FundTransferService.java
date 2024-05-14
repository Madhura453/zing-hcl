package com.zing.app.service;

import com.zing.app.model.FundTransferPayload;
import com.zing.app.model.TransactionDetails;
import org.springframework.stereotype.Service;

@Service
public interface FundTransferService {

    public TransactionDetails createTransfer(FundTransferPayload fundTransferPayload);
}
