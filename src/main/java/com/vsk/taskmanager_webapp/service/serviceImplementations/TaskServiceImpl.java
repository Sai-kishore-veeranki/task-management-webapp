package com.vsk.taskmanager_webapp.service.serviceImplementations;


import com.vsk.taskmanager_webapp.model.TaskEntity;
import com.vsk.taskmanager_webapp.repository.TaskRepository;
import com.vsk.taskmanager_webapp.service.serviceInterfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {


    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public TaskEntity updateTask(Long id, TaskEntity updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setDeadLine(updatedTask.getDeadLine());
                    task.setIsCompleted(updatedTask.getIsCompleted());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

