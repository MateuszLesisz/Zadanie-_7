package com.infoshareacademy.Ex7.controller;

import com.infoshareacademy.Ex7.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskController {

        private final TaskService taskService;

        public TaskController(TaskService taskService) {
            this.taskService = taskService;
        }

    @GetMapping("{id}")
        public String getNewTask(@PathVariable Long id, Model model) {
            model.addAttribute("task",taskService.find(id));
            return "task";
        }

        @GetMapping()
    public String getTasks(Model model) {
            model.addAttribute("tasks", taskService.findAll());
                    return "tasks";
        }
    }

