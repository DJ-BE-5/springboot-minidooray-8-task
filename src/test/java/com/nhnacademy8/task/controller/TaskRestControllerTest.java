package com.nhnacademy8.task.controller;

import com.nhnacademy8.task.entity.Project;
import com.nhnacademy8.task.entity.Task;
import com.nhnacademy8.task.repository.MemberRepository;
import com.nhnacademy8.task.repository.TaskRepository;
import com.nhnacademy8.task.response.TaskResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskRestControllerTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskRestController taskRestController;

    @Test
    void getTasksByProjectId() {

        long projectId = 1L;

        TaskResponse t1 = new TaskResponse(1,"database 설계","ddl 작성 및 erd 다이어그램 정리");
        TaskResponse t2 = new TaskResponse(2,"UI 설계",null);
        TaskResponse t3 = new TaskResponse(3,"페이지 구성","메인 페이지 및 로그인 페이지 구성");


        List<TaskResponse> taskList = Arrays.asList(t1,t2,t3);

        when(taskRepository.getTaskByProjectId(projectId)).thenReturn(taskList);

        ResponseEntity<List<TaskResponse>> responseEntity = taskRestController.getTasksByProjectId(projectId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(taskList, responseEntity.getBody());

    }

    @Test
    void getTaskByTaskId() throws Exception {
        when(taskRepository.existsById(anyLong())).thenReturn(true);
        Project project = new Project(1L,"jieun","A 프로젝트","종료");
        Task task = new Task(1L,project,"database 설계","ddl 작성 및 erd 다이어그램 정리");

        when(taskRepository.getByTaskId(anyLong())).thenReturn(task);

        ResponseEntity<List<TaskResponse>> responseEntity = (ResponseEntity<List<TaskResponse>>) taskRestController.getTaskByTaskId(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(task, responseEntity.getBody());
    }

    @Test
    void createTask() {

    }

    @Test
    void deleteTask() {
    }

    @Test
    void modifyTask() {
    }
}