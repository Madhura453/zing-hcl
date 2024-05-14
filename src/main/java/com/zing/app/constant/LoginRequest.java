package com.zing.app.constant;

import lombok.Data;

@Data
public class LoginRequest {
    private Long customerId;
    private String password;
}
