package com.nhnacademy8.task.controller;

import com.nhnacademy8.task.entity.Tag;
import com.nhnacademy8.task.entity.Task;
import com.nhnacademy8.task.repository.TagRepository;
import com.nhnacademy8.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagRestController {
//    @Autowired
//    private TagRepository tagRepository;
//
//
//    @GetMapping("/getTagList/{taskId}")
//    public ResponseEntity<List<Tag>> getTagsByTaskId(@PathVariable long taskId) {
//        List<Tag> tagList = tagRepository.getAllByTaskTaskId(taskId);
//        return ResponseEntity.ok(tagList);
//    }
//
//    @GetMapping("/getTag/{tagId}")
//    public ResponseEntity<?> getTaskByTaskId(@PathVariable long tagId) {
//        if(!tagRepository.existsById(tagId)){
//            return new ResponseEntity<>("tag not found : "+tagId, HttpStatus.NOT_FOUND);
//        }
//        Task task = tagRepository.getById(tagId);
//        return ResponseEntity.ok(task);
//    }
//
//    @PostMapping()
//    public ResponseEntity<?> createTask(@RequestBody Task task) {
//        taskRepository.save(task);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{taskId}")
//    public ResponseEntity<?> deleteTask(@PathVariable long taskId) {
//        if(!taskRepository.existsById(taskId)){
//            return new ResponseEntity<>("task not found : "+taskId, HttpStatus.NOT_FOUND);
//        }
//        taskRepository.deleteById(taskId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping("/{taskId}")
//    public ResponseEntity<?> modifyTask(@PathVariable long taskId, @RequestBody Task task) {
//        if(!taskRepository.existsById(taskId)){
//            return new ResponseEntity<>("task not found : "+taskId, HttpStatus.NOT_FOUND);
//        }
//        task.setTaskId(taskId);
//        taskRepository.save(task);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
