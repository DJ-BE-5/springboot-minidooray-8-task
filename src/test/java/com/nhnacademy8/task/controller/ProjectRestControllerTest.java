package com.nhnacademy8.task.controller;

import com.nhnacademy8.task.entity.Project;
import com.nhnacademy8.task.repository.MemberRepository;
import com.nhnacademy8.task.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectRestControllerTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectRestController projectRestController;



    @Test
    void getProjectList() {
        String userId = "jieun";
        Project project = new Project(1L,"jieun","A 프로젝트","종료");

        List<Project> projectList = new ArrayList<>();
        projectList.add(project);
        when(projectRepository.findAllByAdminId(anyString())).thenReturn(projectList);
    }

    @Test
    void getProject() {
    }
}