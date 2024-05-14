package com.zing.app.repository;

import com.zing.app.model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundTransferRepository extends JpaRepository<TransactionDetails, Long> {

}
