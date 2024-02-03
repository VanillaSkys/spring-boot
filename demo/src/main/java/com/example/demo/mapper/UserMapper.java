package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.response.RegisterUserResponse;

@Component
public class UserMapper {

    public RegisterUserResponse mapRegisterUserResponse(UserEntity userEntity) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setUsername(userEntity.getUsername());
        return registerUserResponse;
    }
}
