package com.example.demo.service.abstractions;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.BaseException;
import com.example.demo.model.response.LoginUserResponse;

@Service
public interface IUserService {
    UserEntity registerUser(String username, String password) throws BaseException;
    LoginUserResponse loginUser(String username, String password) throws BaseException;
}
