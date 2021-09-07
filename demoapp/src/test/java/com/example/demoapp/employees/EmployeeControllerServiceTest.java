package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Success case")
    void getEmployeeId() {
        // Arrange
        int id = 1;
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Mock name");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        // Act
        EmployeeResponse response = restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
        // Assert
        assertEquals(id, response.getId());
        assertEquals("Mock name", response.getName());
    }

    @Test
    @DisplayName("Failure case :: Employee not found id = 100")
    public void case02() {
        // Arrange
        int id = 100;
        when(employeeRepository.findById(100)).thenReturn(Optional.empty());
        // Act
        ResponseEntity<ErrorResponse> response = restTemplate.getForEntity("/employees/" + id, ErrorResponse.class);
        // Assert
        assertEquals(404, response.getStatusCodeValue());
        assertEquals(404, response.getBody().getCode());
        assertEquals("Employee not found id=100", response.getBody().getDetail());
    }

}
