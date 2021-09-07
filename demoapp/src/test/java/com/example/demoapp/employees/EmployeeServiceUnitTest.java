package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceUnitTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void getEmployeeId() {
        // Arrange
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Mock name");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        // Act
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        EmployeeResponse result = employeeService.getById(1);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("Mock name", result.getName());
    }

    @Test
    void listEmployee() {
    }
}