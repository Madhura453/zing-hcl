package com.zing.app.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "beneficiary_details")
public class BeneficiaryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "beneficiary_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "account_number")
    private int accountNumber;

}
