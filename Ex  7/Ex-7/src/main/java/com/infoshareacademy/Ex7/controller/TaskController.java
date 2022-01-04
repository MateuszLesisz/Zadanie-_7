package com.infoshareacademy.Ex7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping
public String getTask() {
    return "task";
}
}
