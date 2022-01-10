package com.infoshareacademy.Ex7.repository;

import com.infoshareacademy.Ex7.entity.Task;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository extends FakeRepository<Long, Task> {

    private final AtomicLong nextId = new AtomicLong(1L);

    @PostConstruct
    public void initDb() {
    }

    @Override
    Long nextId() {
        return nextId.getAndIncrement();
    }
}
