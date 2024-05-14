package com.zing.app.model;

import com.zing.app.constant.AccountType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction_details")
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private long id;

    @Column(name = "account_number")
    private int accountNumber;

    @Column(name = "transaction_amount")
    private BigDecimal amount;

    @Column(name = "remarks")
    private String remarks;

    @Column(name="transaction_date")
    @CreationTimestamp
    private Date date;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
