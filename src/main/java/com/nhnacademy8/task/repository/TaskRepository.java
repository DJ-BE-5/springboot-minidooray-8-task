package com.nhnacademy8.task.repository;

import com.nhnacademy8.task.entity.Task;
import com.nhnacademy8.task.response.TaskResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> getAllByProjectProjectId(Long projectId);
    @Query("select new com.nhnacademy8.task.response.TaskResponse(t.taskId, t.name, t.detail) from Task t where t.project.projectId = ?1")
    List<TaskResponse> getTaskByProjectId(long projectId);

    Task getByTaskId(Long taskId);
}
