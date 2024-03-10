package com.nhnacademy8.task.controller;

import com.nhnacademy8.task.entity.Project;
import com.nhnacademy8.task.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class MemberRestController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("memberList/{projectId}")
    public ResponseEntity<List<String>> getMemberList(@PathVariable long projectId){
        List<String> memberList = memberRepository.getMemberList(projectId);
        return ResponseEntity.ok(memberList);
    }

    @GetMapping("projectList/{memberId}")
    public ResponseEntity<List<Long>> getProjectList(@PathVariable String memberId){
        List<Long> projectList = memberRepository.getProjectList(memberId);
        return ResponseEntity.ok(projectList);
    }
}
