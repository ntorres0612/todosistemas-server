package com.ntorres.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntorres.task.entity.Task;
import com.ntorres.task.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @SuppressWarnings("rawtypes")
    @GetMapping("/listTasks")
    @ResponseBody
    public List<Task> listTasks() {
        List<Task> list = new ResponseEntity<List>(taskService.tasks(), HttpStatus.OK).getBody();
        return  list;
    }

    @PostMapping("/createTask")
    private Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }
    
    @SuppressWarnings("rawtypes")
    @PostMapping("/findTaskByName")
    public ResponseEntity<List> findTaskByName(@RequestBody Task task) {
        return new ResponseEntity<List>(taskService.findTaskByName(task.getName()), HttpStatus.OK);
    }
    
    @SuppressWarnings("rawtypes")
    @GetMapping("/findByEmployee/{id}")
    @ResponseBody
    public ResponseEntity<List> findByEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<List>(taskService.findByEmployee(id), HttpStatus.OK);
    }

    @PutMapping("/updateTask")
    private Task update(@RequestBody Task task) {
        taskService.update(task);
        return task;
    }

    @DeleteMapping("/deleteTask/{id}")
    private ResponseEntity<?> deleteTask(@PathVariable("id") long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

}
