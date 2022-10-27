package com.ntorres.task.service;

import com.ntorres.task.entity.Employee;
import com.ntorres.task.entity.Task;
import com.ntorres.task.repository.EmployeeRepository;
import com.ntorres.task.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setId(1);
        employee.setName("Nelson Torres");
    }

    @Test
    void listEmployees() {
        when( repository.findAll()).thenReturn(Arrays.asList(employee));
        assertNotNull(repository.findAll());
    }

    @Test
    void save() {
        when( repository.save(any(Employee.class))).thenReturn(employee);
        assertNotNull(repository.save(new Employee()));
    }

}