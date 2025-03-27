package edu.uniminuto.logs_uniminuto.controller;

import edu.uniminuto.logs_uniminuto.controller.payloads.TaskRequest;
import edu.uniminuto.logs_uniminuto.controller.payloads.TaskResponse;
import edu.uniminuto.logs_uniminuto.mappers.TaskMapper;
import edu.uniminuto.logs_uniminuto.model.Task;
import edu.uniminuto.logs_uniminuto.model.services.TaskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    private static final Logger LOGGER = LogManager.getLogger(TaskController.class.getName());

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Long id) {
        LOGGER.info("Get Task by Id");
        return TaskMapper.INSTANCE.taksToTaskResponse(service.getTaskById(id));
    }

    @GetMapping
    public List<TaskResponse> getAllTask() {
        List<Task> clientes = service.getAllTask();
        LOGGER.info("Get All Task");
        return clientes.stream()
                .map(TaskMapper.INSTANCE::taksToTaskResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public TaskResponse saveTask(@RequestBody TaskRequest taskRequest) {
        LOGGER.debug("Save Task - Warn");
        LOGGER.trace("Save Task - Debug mode");
        return TaskMapper.INSTANCE.taksToTaskResponse(service.saveTask(taskRequest));
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
        LOGGER.info("Update Task");
        return TaskMapper.INSTANCE.taksToTaskResponse(service.updateTask(id, taskRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        LOGGER.error("Save Task");
        service.deleteTask(id);
    }
}
