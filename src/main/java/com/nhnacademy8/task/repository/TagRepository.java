package com.nhnacademy8.task.repository;

import com.nhnacademy8.task.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> getAllByTaskTaskId(long taskId);
}
