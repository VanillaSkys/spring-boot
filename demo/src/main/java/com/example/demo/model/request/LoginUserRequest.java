package com.example.demo.model.request;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String username;
    private String password;
}
