package com.example.demo.service.concretions;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.UserException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.abstractions.IUserService;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity registerUser(String username, String password) throws BaseException {
        if(Objects.isNull(username)) {
            throw UserException.usernameIsNull();
        }
        if(Objects.isNull(password)) {
            throw UserException.passwordIsNull();
        }
        if(username.isEmpty()) {
            throw UserException.usernameIsEmpty();
        }
        if(password.isEmpty()) {
            throw UserException.passwordIsEmpty();
        }
        if(userRepository.existsByUsername(username)) {
            throw UserException.usernameIsExists();
        }
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(username);
        userEntity.setPassword(passwordEncoder.encode(password));

        RoleEntity roleEntity = roleRepository.findByName("USER").get();
        userEntity.setRoles(Collections.singletonList(roleEntity));

        return userRepository.save(userEntity);
    }

    public String loginUser(String username, String password) throws BaseException {
        
        if(Objects.isNull(username)) {
            throw UserException.usernameIsNull();
        }
        if(Objects.isNull(password)) {
            throw UserException.passwordIsNull();
        }
        if(username.isEmpty()) {
            throw UserException.usernameIsEmpty();
        }
        if(password.isEmpty()) {
            throw UserException.passwordIsEmpty();
        }
        
        Optional<UserEntity> opt = userRepository.findByUsername(username);
        if(opt.isEmpty()) {
            throw UserException.usernameIsNull();
        }
        UserEntity userEntity = opt.get();
        if(!matchPassword(password, userEntity.getPassword())) {
            throw UserException.passwordIsEmpty();
        }
        

        return "YES";
    }

    public boolean matchPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
