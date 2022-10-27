package com.ntorres.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntorres.task.entity.Employee;
import com.ntorres.task.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> listEmployees() {
        return (List<Employee>) repository.findAll();
    }
    
    public void delete(long id) {
        repository.deleteById(id);
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Employee update(Employee employee) {
       return repository.save(employee);
    }
}
