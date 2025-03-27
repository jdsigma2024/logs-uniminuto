package edu.uniminuto.logs_uniminuto.mappers;

import edu.uniminuto.logs_uniminuto.controller.payloads.TaskRequest;
import edu.uniminuto.logs_uniminuto.controller.payloads.TaskResponse;
import edu.uniminuto.logs_uniminuto.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task taskRequestToTask(TaskRequest taskRequest);

    TaskResponse taksToTaskResponse(Task task);

    void updateTaskFromTaskRequest(TaskRequest taskRequest, @MappingTarget Task task);
}
