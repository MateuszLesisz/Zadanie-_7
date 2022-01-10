package com.infoshareacademy.Ex7.service;

import com.infoshareacademy.Ex7.dto.TaskDto;
import com.infoshareacademy.Ex7.entity.Task;
import com.infoshareacademy.Ex7.mappers.TaskMapper;
import com.infoshareacademy.Ex7.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
        Task task = mapper.toEntity(dto);
        repository.save(task);
    }

    public TaskDto find(Long id) {
        Task task = repository.findById(id);
        return mapper.toDto(task);
    }

    public List<TaskDto> findAll() {
        Collection<Task> tasks = repository.findAll();
        return tasks.stream().map(mapper::toDto).collect(Collectors.toList());
    }
}

