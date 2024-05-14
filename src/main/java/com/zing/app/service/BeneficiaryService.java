package com.zing.app.service;

import com.zing.app.model.BeneficiaryDetails;
import com.zing.app.model.Customer;
import com.zing.app.repository.BeneficiaryRepository;
import com.zing.app.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryService {
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;
    @Autowired
    private LoginRepository loginRepository;

    public List<BeneficiaryDetails> findAllBeneficiaryDetails(Long customerId) {
        Optional<Customer> byId = loginRepository.findById(customerId);
        if (byId.isPresent()) {
            return beneficiaryRepository.findAll();
        } else {
            return new ArrayList<>();
        }
    }
}
