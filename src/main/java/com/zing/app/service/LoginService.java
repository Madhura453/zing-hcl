package com.zing.app.service;

import com.zing.app.constant.LoginRequest;
import com.zing.app.constant.LoginResponse;
import com.zing.app.model.Customer;
import com.zing.app.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public LoginResponse validateUserLogin(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCustomerId(loginRequest.getCustomerId());
        Optional<Customer> byId = loginRepository.findById(loginRequest.getCustomerId());
        if (byId.isPresent()) {
            Customer customer = byId.get();
            if (customer.getPassword().equals(loginRequest.getPassword())) {
                loginResponse.setMessage("User is login successful");
            } else {
                loginResponse.setMessage("Entered password is not match with database password");
            }
        } else {
            loginResponse.setMessage("Entered customer id is not present in database");
        }
        return loginResponse;
    }
}
