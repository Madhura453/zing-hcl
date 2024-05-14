package com.zing.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private List<BeneficiaryDetails> beneficiaryDetails;

}
