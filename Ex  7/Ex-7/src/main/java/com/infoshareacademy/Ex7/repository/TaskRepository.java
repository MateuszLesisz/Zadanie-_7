package com.infoshareacademy.Ex7.repository;

import com.infoshareacademy.Ex7.entity.Task;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository extends FakeRepository<Long, Task> {

    private static final int WEEKEND = 2;
    private final AtomicLong nextId = new AtomicLong(1L);

    @PostConstruct
    public void initDb() {

        Task threads = new Task();
        threads.setDescription("threads");
        threads.setDueDate(LocalDate.now().plusDays(WEEKEND));
        threads.setCategory("asfas");
        threads.setPriority(12);
        save(threads);

        Task task2 = new Task();
        task2.setDescription("task2");
        task2.setDueDate(LocalDate.now());
        task2.setCategory("12321");
        task2.setPriority(14);
        save(task2);

        Task task3 = new Task();
        task3.setDescription("task3");
        task3.setDueDate(LocalDate.now());
        task3.setCategory("12321");
        task3.setPriority(14234);
        save(task3);

    }

    @Override
    Long nextId() {
        return nextId.getAndIncrement();
    }
}
