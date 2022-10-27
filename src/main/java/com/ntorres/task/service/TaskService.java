package com.ntorres.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntorres.task.entity.Task;
import com.ntorres.task.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> tasks() {
        return (List<Task>) repository.findAll();
    }
    
    public List<Task> findByEmployee(Long id) {
        return (List<Task>) repository.findByEmployeeId(id);
    }
    
    public List<Task> findTaskByName(String name) {
        return (List<Task>) repository.findByNameIgnoreCaseContaining(name);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public Task save(Task task) {
       return repository.save(task);
    }

    public void update(Task task) {
        repository.save(task);
    }
}
