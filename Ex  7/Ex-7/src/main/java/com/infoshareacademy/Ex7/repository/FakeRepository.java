package com.infoshareacademy.Ex7.repository;

import com.infoshareacademy.Ex7.entity.Entity;
import com.infoshareacademy.Ex7.entity.Task;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class FakeRepository<T, E extends Entity<T>> {
    private final Map<T, E> fakeDb = new ConcurrentHashMap<>();

    public void save(E entity) {
        T id = entity.getId();
        if (id == null) {
            entity.setId(nextId());
        }
        fakeDb.put(entity.getId(), entity);
        persistDb();
    }

    public E findById(T id) {
        return fakeDb.get(id);
    }

    abstract T nextId();

    public Collection<E> findAll() {
        return fakeDb.values();
    }

    abstract void persistDb();



}
