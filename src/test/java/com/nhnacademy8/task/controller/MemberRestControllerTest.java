package com.nhnacademy8.task.controller;

import com.nhnacademy8.task.entity.Project;
import com.nhnacademy8.task.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberRestControllerTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberRestController memberRestController;


    @Test
    void getMemberList() {
        long projectId = 1L;
        List<String> mockMemberList = Arrays.asList("jieun", "sukjoon","dongyeong");

        when(memberRepository.getMemberList(projectId)).thenReturn(mockMemberList);
        ResponseEntity<List<String>> responseEntity = memberRestController.getMemberList(projectId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<String> responseBody = responseEntity.getBody();
        assertEquals(mockMemberList, responseBody);
    }

    @Test
    void getProjectList() {
        String memberId = "jieun";
        List<Long> mockProjectList = Arrays.asList(1L,2L);

        when(memberRepository.getProjectList(memberId)).thenReturn(mockProjectList);

        ResponseEntity<List<Long>> responseEntity = memberRestController.getProjectList(memberId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<Long> responseBody = responseEntity.getBody();
        assertEquals(mockProjectList, responseBody);
    }
}