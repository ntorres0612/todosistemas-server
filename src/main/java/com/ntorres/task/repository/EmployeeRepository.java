package com.ntorres.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntorres.task.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
