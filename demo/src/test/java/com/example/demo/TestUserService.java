package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.concretions.UserService;

@SpringBootTest
public class TestUserService {
    
    private final UserService userService;

    private interface TestData {
        String username = "natthanon";
        String password = "nat1234";
    }
    public TestUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    void testRegister() {
        
    }
}
