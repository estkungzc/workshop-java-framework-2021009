package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getEmployeeId() {
        // Arrange
        int id = 100;
        // Act
        EmployeeResponse response = restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
        // Assert
        assertEquals(id, response.getId());
        assertEquals("chairat", response.getName());
    }

    @Test
    void listEmployee() {
        // Act
        EmployeeResponse[] responses = restTemplate.getForObject("/employees", EmployeeResponse[].class);
        // Assert
        assertEquals(2, responses.length);
        assertEquals(1, responses[0].getId());
        assertEquals("chairat", responses[0].getName());
    }
}