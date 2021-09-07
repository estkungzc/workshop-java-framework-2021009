package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerFailureTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("เกิด error 404 เมื่อค้นหา employee id = 1 ไม่เจอ")
    void case01() {
        // Arrange
        int id = 1;
        // Act
        ResponseEntity<ErrorResponse> response = restTemplate.getForEntity("/employees/" + id, ErrorResponse.class);
        // Assert
        assertEquals(404, response.getStatusCodeValue());
//        assertEquals(404, response.getCode());
//        assertEquals("Employee not found id=1", response.getDetail());
    }
}
