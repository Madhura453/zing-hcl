package com.zing.app.service;

import com.zing.app.exception.AccountDetailsNotFoundException;
import com.zing.app.exception.CustomerNotFoundException;
import com.zing.app.model.AccountDetails;
import com.zing.app.model.AccountResponseDto;
import com.zing.app.model.Customer;
import com.zing.app.model.TransactionDetails;
import com.zing.app.repository.AccountDetailsRepository;
import com.zing.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDetailsRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public AccountDetails getAccountDetails(Long customerId) {
        Customer customer = findCustomer(customerId);
        return accountRepository.findByCustomer(customer).orElseThrow(() -> new AccountDetailsNotFoundException(HttpStatus.NOT_FOUND.value(), "Unable to find Account Details", HttpStatus.NOT_FOUND));
    }

    @Override
    public AccountResponseDto getAccountSummary(Long customerId) {
        Customer customer = findCustomer(customerId);

        AccountDetails accountDetails =
                accountRepository.findByCustomer(customer).orElseThrow(() ->
                        new AccountDetailsNotFoundException(HttpStatus.NOT_FOUND.value(),
                                "Unable to find Account Details", HttpStatus.NOT_FOUND));

            AccountResponseDto accountResponseDto = new AccountResponseDto();
            accountResponseDto.setAccountNumber(accountDetails.getAccountNumber());
            accountResponseDto.setAmount(accountDetails.getBalance());
            accountResponseDto.setCreationDate(LocalDate.now());
            // Limit only 10 transactions
            List<TransactionDetails> transactionDetails = accountDetails.getTransaction()
                    .stream().limit(10).toList();
            accountResponseDto.setTransactionDetails(transactionDetails);
            return accountResponseDto;
    }

    public Customer findCustomer(Long customerId)
    {
        return customerRepository.findById(customerId)
                .orElseThrow(()->new CustomerNotFoundException(HttpStatus.NOT_FOUND.value(), "Unable to find customer", HttpStatus.NOT_FOUND));
    }

}
