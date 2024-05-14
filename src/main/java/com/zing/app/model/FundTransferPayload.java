package com.zing.app.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundTransferPayload {
    private BeneficiaryDetails benificiaryDetails;
    private BigDecimal amount;
    private String remarks;
}
