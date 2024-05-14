package com.zing.app.repository;


import com.zing.app.model.AccountDetails;
import com.zing.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails,Long> {

    Optional<AccountDetails> findByCustomer(Customer customer);
}
