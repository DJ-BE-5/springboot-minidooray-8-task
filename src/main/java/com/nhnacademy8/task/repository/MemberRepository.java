package com.nhnacademy8.task.repository;

import com.nhnacademy8.task.entity.Member;
import com.nhnacademy8.task.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query("select m.memberId from Member m where m.project.projectId = ?1")
    List<String> getMemberList(long projectId);


    @Query("select m.project.projectId from Member m where m.memberId = ?1")
    List<Long> getProjectList(String memberId);
}
