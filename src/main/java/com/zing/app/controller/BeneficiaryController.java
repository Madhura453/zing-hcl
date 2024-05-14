package com.zing.app.controller;

import com.zing.app.model.BeneficiaryDetails;
import com.zing.app.service.BeneficiaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeneficiaryController {

    private static Logger logger = LoggerFactory.getLogger(BeneficiaryController.class);
    @Autowired
    private BeneficiaryService beneficiaryService;

    @GetMapping("/v1/mybank/beneficiaries/{customerId}")
    public ResponseEntity<List<BeneficiaryDetails>> fetchAllBeneficiaryDetails(@PathVariable Long customerId) {
        logger.info("Beneficiary started");
        List<BeneficiaryDetails> allBeneficiaryDetails = beneficiaryService.findAllBeneficiaryDetails(customerId);
        if (!allBeneficiaryDetails.isEmpty()) {
            return new ResponseEntity<>(allBeneficiaryDetails, HttpStatus.OK);
        }
        return new ResponseEntity<>(allBeneficiaryDetails, HttpStatus.NOT_FOUND);
    }
}
