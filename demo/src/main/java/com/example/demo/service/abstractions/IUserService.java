package com.example.demo.service.abstractions;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.BaseException;

@Service
public interface IUserService {
    UserEntity registerUser(String username, String password) throws BaseException;
    String loginUser(String username, String password) throws BaseException;
}
