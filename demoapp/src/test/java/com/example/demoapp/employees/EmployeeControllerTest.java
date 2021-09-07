package com.example.demoapp.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private EmployeeRepository employeeRepository;

    @AfterEach
    public void deleteDataForTest() {
        employeeRepository.deleteAll();
    }

    @Test
    public void getEmployeeById() {
        // Arrange
        int id = 1;
        Employee employee100 = new Employee();
        employee100.setName("chairat");
        employeeRepository.save(employee100);
        // Act
        EmployeeResponse result
                = restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
        // Assert
        assertEquals(id, result.getId());
        assertEquals("chairat", result.getName());
    }

    @Test
    public void listEmployee() {
        // Act
        EmployeeResponse[] results
                = restTemplate.getForObject("/employees", EmployeeResponse[].class);
        // Assert
        assertEquals(2, results.length);
        assertEquals(1, results[0].getId());
        assertEquals("chairat", results[0].getName());
    }
}