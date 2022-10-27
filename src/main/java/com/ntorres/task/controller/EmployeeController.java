package com.ntorres.task.controller;

import java.util.List;

import com.ntorres.task.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntorres.task.entity.Employee; 
import com.ntorres.task.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @SuppressWarnings("rawtypes")
    @GetMapping("/listEmployees")
    @ResponseBody
    public ResponseEntity<List> listEmployees() {
        return new ResponseEntity<List>(employeeService.listEmployees(), HttpStatus.OK);
    }

    @PostMapping("/createEmployee")
    private Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/updateEmployee")
    private Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    private ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }
    
    

}
