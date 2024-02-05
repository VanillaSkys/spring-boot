package com.example.demo.cmd;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.ConvertStringToEntity;

@Component
public class AdminDataLoader implements CommandLineRunner {
    
    private UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;

    public AdminDataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) throws Exception {
        createAdmin("admin", "root");
    }

    private void createAdmin(String username, String password) {
        if (!userRepository.existsByUsername(username)) {
            UserEntity newAdmin = new UserEntity();
            newAdmin.setUsername(username);
            newAdmin.setPassword(passwordEncoder.encode(password));
            RoleEntity roleEntity = ConvertStringToEntity.convertToRoleEntity("ADMIN");
            newAdmin.setRoles(Collections.singletonList(roleEntity));
            userRepository.save(newAdmin);
        }
    }
}
