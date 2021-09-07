package com.example.demoapp;

import com.example.demoapp.employees.Employee;
import com.example.demoapp.employees.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class InitializeData {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @PostConstruct
    public void genData() {
        Employee employee = new Employee();
        employee.setId(1000);
        employee.setName("chairat");
        employeeRepository.save(employee);
    }
}
