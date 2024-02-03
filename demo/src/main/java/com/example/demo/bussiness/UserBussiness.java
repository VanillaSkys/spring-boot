package com.example.demo.bussiness;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.BaseException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.request.LoginUserRequest;
import com.example.demo.model.request.RegisterUserRequest;
import com.example.demo.model.response.RegisterUserResponse;
import com.example.demo.service.abstractions.IUserService;

@Service
public class UserBussiness {
    
    private IUserService userService;
    private UserMapper userMapper;

    public UserBussiness(IUserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public RegisterUserResponse registerUser(RegisterUserRequest request) throws BaseException {
        UserEntity userEntity = userService.registerUser(request.getUsername(), request.getPassword());
        return userMapper.mapRegisterUserResponse(userEntity);
    }

    public String loginUser(LoginUserRequest request) throws BaseException {
        String userEntity = userService.loginUser(request.getUsername(), request.getPassword());
        return userEntity;
    }
}
