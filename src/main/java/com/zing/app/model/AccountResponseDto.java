package com.zing.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountResponseDto {

    private int accountNumber;

    private BigDecimal amount;

    private LocalDate creationDate;

    private List<TransactionDetails> transactionDetails;

}
