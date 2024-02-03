package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bussiness.UserBussiness;
import com.example.demo.exception.BaseException;
import com.example.demo.model.request.LoginUserRequest;
import com.example.demo.model.request.RegisterUserRequest;
import com.example.demo.model.response.RegisterUserResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/public")
public class User {
    
    private UserBussiness bussiness;


    public User(UserBussiness bussiness) {
        this.bussiness = bussiness;
    }
    
    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest request) throws BaseException {
        RegisterUserResponse response = bussiness.registerUser(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginUserRequest request) throws BaseException {
        String response = bussiness.loginUser(request);
        return ResponseEntity.ok(response);
    }
    
    
}
