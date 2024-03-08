package com.nhnacademy8.task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @Column(name = "tag_id")
    long tagId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;

    @Column(name = "name", nullable = false)
    String name;

}
