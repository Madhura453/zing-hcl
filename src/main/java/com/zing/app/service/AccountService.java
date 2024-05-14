package com.zing.app.service;

import com.zing.app.model.AccountDetails;
import com.zing.app.model.AccountResponseDto;

public interface AccountService {

    AccountDetails getAccountDetails(Long customerId);

    AccountResponseDto getAccountSummary(Long customerId);
}
