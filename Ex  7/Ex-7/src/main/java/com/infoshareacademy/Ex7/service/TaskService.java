package com.infoshareacademy.Ex7.service;

import com.infoshareacademy.Ex7.dto.TaskDto;
import com.infoshareacademy.Ex7.entity.Task;
import com.infoshareacademy.Ex7.mappers.TaskMapper;
import com.infoshareacademy.Ex7.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {


    private final TaskRepository repository;
    private final TaskMapper mapper;

    @Autowired
    public TaskService(TaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void create(TaskDto dto) {
        Task project = mapper.toEntity(dto);
        repository.save(project);
    }

    public TaskDto find(Long id) {
        Task project = repository.findById(id);
        return mapper.toDto(project);
    }
}

