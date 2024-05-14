package com.zing.app.repository;

import com.zing.app.model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<TransactionDetails,Long> {
}
