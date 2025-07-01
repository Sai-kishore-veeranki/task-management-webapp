package com.vsk.taskmanager_webapp.service.serviceInterfaces;

import com.vsk.taskmanager_webapp.model.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    TaskEntity createTask(TaskEntity task);
    List<TaskEntity> getAllTasks();
    Optional<TaskEntity> getTaskById(Long id);
    TaskEntity updateTask(Long id, TaskEntity task);
    void deleteTask(Long id);
}

