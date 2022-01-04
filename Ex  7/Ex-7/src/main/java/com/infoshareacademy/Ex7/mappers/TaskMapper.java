package com.infoshareacademy.Ex7.mappers;

import com.infoshareacademy.Ex7.dto.TaskDto;
import com.infoshareacademy.Ex7.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setDescription(task.getDescription());
        dto.setCategory(task.getCategory());
        dto.setDueDate(task.getDueDate());
        dto.setPriority(task.getPriority());

        return dto;
    }

    public Task toEntity(TaskDto task) {
        Task entity = new Task();
        entity.setId(task.getId());
        entity.setDescription(task.getDescription());
        entity.setCategory(task.getCategory());
        entity.setDueDate(task.getDueDate());
        entity.setPriority(task.getPriority());

        return entity;
    }
}