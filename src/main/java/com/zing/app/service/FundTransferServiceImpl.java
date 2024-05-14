package com.zing.app.service;

import com.zing.app.exception.InsufficientFundException;
import com.zing.app.model.AccountDetails;
import com.zing.app.model.FundTransferPayload;
import com.zing.app.model.TransactionDetails;
import com.zing.app.repository.AccountDetailsRepository;
import com.zing.app.repository.FundTransferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class FundTransferServiceImpl implements FundTransferService{

    @Autowired
    FundTransferRepository repository;

    @Autowired
    AccountDetailsRepository accountDetailsRepository;

    /**
     * This Method is used to transfer Fund and will insert a record in transaction table
     * @param fundTransferPayload
     * @return
     */
    @Override
    public TransactionDetails createTransfer(FundTransferPayload fundTransferPayload) {

        TransactionDetails transactionDetails =  repository.save(dtoToEntity(fundTransferPayload));
        updateAccountBalance(fundTransferPayload);
        return transactionDetails;
    }

    /**
     * This method is used to deduct amount from existing balance
     * @param fundTransferPayload
     */

    public void updateAccountBalance(FundTransferPayload fundTransferPayload){
        AccountDetails accountDetails = new AccountDetails();
        long id= fundTransferPayload.getBenificiaryDetails().getId();
        Optional<AccountDetails> getFundTransferDetails = accountDetailsRepository.findById(id);
        if(!getFundTransferDetails.isEmpty()){
            accountDetails.setAccountNumber(fundTransferPayload.getBenificiaryDetails().getAccountNumber());
            accountDetails.setAccountType(getFundTransferDetails.get().getAccountType());
            BigDecimal existBalanceAmount =getFundTransferDetails.get().getBalance();
            if(fundTransferPayload.getAmount().signum()>0) {
                if (existBalanceAmount.compareTo(fundTransferPayload.getAmount()) == 1) {
                    BigDecimal updatedBalanceAmount = existBalanceAmount.subtract(fundTransferPayload.getAmount());
                    accountDetails.setBalance(updatedBalanceAmount);
                    accountDetailsRepository.save(accountDetails);
                } else {
                    throw new InsufficientFundException("Insuffiecient Fund in Account!");
                }
            }else{
                throw new InsufficientFundException("Negative amount is not acceptable!");
            }
        }
    }

    public TransactionDetails dtoToEntity(FundTransferPayload fundTransferPayload){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(fundTransferPayload,TransactionDetails.class);

    }
}
