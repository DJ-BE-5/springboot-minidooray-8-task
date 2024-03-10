package com.nhnacademy8.task.controller;

import com.nhnacademy8.task.entity.Task;
import com.nhnacademy8.task.repository.ProjectRepository;
import com.nhnacademy8.task.repository.TaskRepository;
import com.nhnacademy8.task.response.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskRestController {

    @Autowired
    private TaskRepository taskRepository;


    @GetMapping("/taskList/{projectId}")
    public ResponseEntity<List<TaskResponse>> getTasksByProjectId(@PathVariable long projectId) {
        List<TaskResponse> taskList = taskRepository.getTaskByProjectId(projectId);
        return ResponseEntity.ok(taskList);
    }

    @GetMapping("/taskDetail/{taskId}")
    public ResponseEntity<?> getTaskByTaskId(@PathVariable long taskId) {
        if(!taskRepository.existsById(taskId)){
            return new ResponseEntity<>("task not found : "+taskId, HttpStatus.NOT_FOUND);
        }
        Task task = taskRepository.getByTaskId(taskId);
        return ResponseEntity.ok(task);
    }

    @PostMapping()
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        taskRepository.save(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable long taskId) {
        if(!taskRepository.existsById(taskId)){
            return new ResponseEntity<>("task not found : "+taskId, HttpStatus.NOT_FOUND);
        }
        taskRepository.deleteById(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> modifyTask(@PathVariable long taskId, @RequestBody Task task) {
        if(!taskRepository.existsById(taskId)){
            return new ResponseEntity<>("task not found : "+taskId, HttpStatus.NOT_FOUND);
        }
        task.setTaskId(taskId);
        taskRepository.save(task);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}