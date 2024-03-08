package com.nhnacademy8.task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    long taskId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    Project project;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "detail")
    String detail;
}
