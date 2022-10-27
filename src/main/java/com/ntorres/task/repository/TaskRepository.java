package com.ntorres.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntorres.task.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByNameIgnoreCaseContaining(String name);
    List<Task> findByEmployeeId(Long employee_id);
}
