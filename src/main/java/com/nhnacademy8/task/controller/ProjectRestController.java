package com.nhnacademy8.task.controller;

import com.nhnacademy8.task.entity.Project;
import com.nhnacademy8.task.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/projects")
public class ProjectRestController {
    @Autowired
    private ProjectRepository projectRepository;


    @GetMapping("/projectList/{adminId}")
    public ResponseEntity<List<Project>> getProjectList(@PathVariable String adminId){
        List<Project> projectList = projectRepository.findAllByAdminId(adminId);
        return ResponseEntity.ok(projectList);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProject(@PathVariable long projectId){
        if(!projectRepository.existsById(projectId)){
            return new ResponseEntity<>("project not found : "+projectId, HttpStatus.NOT_FOUND);
        }

        Project project = projectRepository.getByProjectId(projectId);
        return ResponseEntity.ok(project);
    }

    @PostMapping
    public ResponseEntity<?> postProject(@RequestBody Project project){
        Project saveResult = projectRepository.save(project);
        return new ResponseEntity<>(saveResult,HttpStatus.CREATED);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<?> modifyProject(@PathVariable long projectId, @RequestBody Project project){
        if(!projectRepository.existsById(projectId)){
            return new ResponseEntity<>("project not found : "+projectId, HttpStatus.NOT_FOUND);
        }
        project.setProjectId(projectId);
        projectRepository.save(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable long projectId){
        if(!projectRepository.existsById(projectId)){
            return new ResponseEntity<>("project not found : "+projectId, HttpStatus.NOT_FOUND);
        }
        projectRepository.deleteById(projectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
