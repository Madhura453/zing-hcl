package com.zing.app.model;

import com.zing.app.constant.AccountType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "account_details")
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private long id;

    @Column(name = "account_number")
    private int accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "remaining_balance")
    private BigDecimal balance;

    @OneToMany
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private List<TransactionDetails> transaction;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
