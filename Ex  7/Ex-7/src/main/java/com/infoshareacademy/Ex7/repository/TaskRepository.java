package com.infoshareacademy.Ex7.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.Ex7.entity.Task;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository extends FakeRepository<Long, Task> {

    private final AtomicLong nextId = new AtomicLong(1L);
    private static final String TASK_REPOSITORY_JSON_FILE = "src/main/resources/taskList.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @PostConstruct
    public void initDb() {
    }

    @Override
    Long nextId() {
        return nextId.getAndIncrement();
    }

    @Override
    void persistDb() {
        List<Task> tasks = new ArrayList<>(this.findAll());
        try {
            Writer fileWriter = new BufferedWriter(new FileWriter(TASK_REPOSITORY_JSON_FILE));
            gson.toJson(tasks, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
