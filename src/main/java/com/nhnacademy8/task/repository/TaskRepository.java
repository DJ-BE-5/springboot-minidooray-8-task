package com.nhnacademy8.task.repository;

import com.nhnacademy8.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> getAllByProjectProjectId(Long projectId);

    Task getByTaskId(Long taskId);
}
