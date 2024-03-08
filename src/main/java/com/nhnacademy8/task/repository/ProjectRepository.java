package com.nhnacademy8.task.repository;

import com.nhnacademy8.task.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    @Override
    boolean existsById(Long projectId);

    @Override
    Project save(Project project);

    Project getByProjectId(Long projectId);
    @Override
    void deleteById(Long projectId);


    List<Project> findAllByAdminId(String userId);
}
