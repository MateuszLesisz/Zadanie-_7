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
        threads.setCategory("ABC");
        threads.setPriority(1);
        save(threads);

        Task explore = new Task();
        threads.setDescription("explore");
        threads.setDueDate(LocalDate.now().plusDays(WEEKEND));
        threads.setCategory("ABC");
        threads.setPriority(1);
        save(explore);

        Task lines = new Task();
        threads.setDescription("lines");
        threads.setDueDate(LocalDate.now().plusDays(WEEKEND));
        threads.setCategory("ABC");
        threads.setPriority(1);
        save(lines);

    }

    @Override
    Long nextId() {
        return nextId.getAndIncrement();
    }
}
