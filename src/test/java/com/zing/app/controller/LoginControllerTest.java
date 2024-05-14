package com.zing.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zing.app.constant.LoginRequest;
import com.zing.app.constant.LoginResponse;
import com.zing.app.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @MockBean
    private LoginService loginService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void givenCorrectUsernamePassword_loginSuccessfully() throws Exception{

        long id = 1L;
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCustomerId(id);
        loginResponse.setMessage("User is login successful");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setCustomerId(id);
        loginRequest.setPassword("1234");
        when(loginService.validateUserLogin(loginRequest)).thenReturn(loginResponse);
        mockMvc.perform(post("/v1/mybank/login").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void givenWrongUsername_getErrorResponse() throws Exception{

        long id = 1L;
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCustomerId(id);
        loginResponse.setMessage("Entered customer id is not present in database");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setCustomerId(id);
        loginRequest.setPassword("1234");
        when(loginService.validateUserLogin(loginRequest)).thenReturn(loginResponse);
        mockMvc.perform(post("/v1/mybank/login").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void givenWrongPassword_getErrorResponse() throws Exception{

        long id = 1L;
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCustomerId(id);
        loginResponse.setMessage("Entered password is not match with database password");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setCustomerId(id);
        loginRequest.setPassword("1234");
        when(loginService.validateUserLogin(loginRequest)).thenReturn(loginResponse);
        mockMvc.perform(post("/v1/mybank/login").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

}
