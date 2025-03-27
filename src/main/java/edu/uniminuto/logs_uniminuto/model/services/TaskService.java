package edu.uniminuto.logs_uniminuto.model.services;

import edu.uniminuto.logs_uniminuto.controller.payloads.TaskRequest;
import edu.uniminuto.logs_uniminuto.controller.payloads.TaskResponse;
import edu.uniminuto.logs_uniminuto.mappers.TaskMapper;
import edu.uniminuto.logs_uniminuto.model.Task;
import edu.uniminuto.logs_uniminuto.model.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.orElse(null);
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task saveTask(TaskRequest taskRequest) {
        Task cliente = TaskMapper.INSTANCE.taskRequestToTask(taskRequest);
        return taskRepository.save(cliente);
    }

    public Task updateTask(Long id, TaskRequest taskRequest) {
        return taskRepository.findById(id).map(existingTask -> {
            TaskMapper.INSTANCE.updateTaskFromTaskRequest(taskRequest, existingTask);
            return taskRepository.save(existingTask);
        }).orElse(null);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
