package com.infoshareacademy.Ex7.controller;

import com.infoshareacademy.Ex7.dto.TaskDto;
import com.infoshareacademy.Ex7.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormController {
    private final TaskService taskService;

    public FormController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("tasks/new")
    public String getTaskForm(Model model) {
        model.addAttribute("task", new TaskDto());
        return "form";

    }

    @PostMapping("tasks/new")
    public String sendTask(@Valid @ModelAttribute("task") TaskDto task,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        taskService.create(task);
        return "form-succes";
    }


}
