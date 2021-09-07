package com.example.demoapp.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserGatewayTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    void getUserById() {
        // Act
        Optional<UserResponse> response = userGateway.getUserById(1);
        // Assert
        assertTrue(response.isPresent());
        assertEquals(1, response.get().getId());
        assertEquals("Bret", response.get().getUsername());
    }
}