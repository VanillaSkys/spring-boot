package com.example.demo.service.concretions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.CustomUserDetailService;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.UserException;
import com.example.demo.model.response.LoginUserResponse;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.abstractions.IUserService;
import com.example.demo.util.JwtService;

@Service
public class UserService implements IUserService {

    private  UserRepository userRepository;
    private  RoleRepository roleRepository;
    private  PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private CustomUserDetailService customUserDetailService;
    private AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtService jwtService, CustomUserDetailService customUserDetailService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.customUserDetailService = customUserDetailService;
        this.authenticationManager = authenticationManager;
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

    public LoginUserResponse loginUser(String username, String password) throws BaseException {
        
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
        
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );
        UserDetails user = customUserDetailService.loadUserByUsername(username);
        Map<String, Object> extraclaims = new HashMap<>();
        user.getAuthorities().stream().forEach(authority -> {
            extraclaims.put("authority", authority);
        });
        String jwtToken = jwtService.generateToken(extraclaims, user);
        LoginUserResponse response = new LoginUserResponse();
        response.setToken(jwtToken);

        return response;
    }

    public boolean matchPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
