package com.ntorres.task.service;

import com.ntorres.task.entity.Task;
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
class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService taskService;

    private Task task;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        task = new Task();
        task.setId(1);
        task.setName("Task 1");
        task.setStatus("pending");
    }

    @Test
    void tasks() {
        when( repository.findAll()).thenReturn(Arrays.asList(task));
        assertNotNull(repository.findAll());
    }

    @Test
    void save() {
        when( repository.save(any(Task.class))).thenReturn(task);
        assertNotNull(repository.save(task));
    }


}