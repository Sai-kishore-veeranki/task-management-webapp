package com.vsk.taskmanager_webapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.Date;

@Data
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private Date deadLine;
    private Boolean isCompleted;

    @Column(length = 1000)
    private String note;
}
