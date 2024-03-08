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
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    long projectId;

    @Column(name = "admin_id", nullable = false)
    String adminId;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "status", nullable = false)
    String status;

//    public Project(long adminId, String name, String status) {
//        this.adminId = adminId;
//        this.name = name;
//        this.status = status;
//    }
}
