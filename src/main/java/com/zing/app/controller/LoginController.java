package com.zing.app.controller;

import com.zing.app.constant.LoginRequest;
import com.zing.app.constant.LoginResponse;
import com.zing.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/v1/mybank/login")
    public ResponseEntity<LoginResponse> userLoginValidate(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = loginService.validateUserLogin(loginRequest);
        if (loginResponse.getMessage().equals("User is login successful")) {
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
    }

}
