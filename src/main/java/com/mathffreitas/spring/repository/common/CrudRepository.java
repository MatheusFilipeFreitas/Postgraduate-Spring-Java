package com.mathffreitas.spring.repository.common;

import com.mathffreitas.spring.model.common.BaseIdModel;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class CrudRepository<T extends BaseIdModel, ID> {
    private final LinkedHashMap<ID, T> memoryDatabase = new LinkedHashMap<>();
    private final AtomicInteger sequenceGenerator = new AtomicInteger(1);

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(memoryDatabase.get(id));
    }

    public List<T> findAll() {
        return memoryDatabase.values().stream().toList();
    }

    @SuppressWarnings("unchecked")
    public T save(T entity) {
        Integer nextId = handleNextId();
        ID id = (ID) nextId; // suppressed: in this case the id will be integer!
        if (entity.getId() == null) {
            entity.setId(nextId);
        }
        memoryDatabase.put(id, entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public Optional<T> update(T entity) {
        Optional<T> optinalEntity = this.findById((ID) entity.getId()); // suppressed: in this case the id will be integer!
        if (optinalEntity.isPresent()) {
            memoryDatabase.put((ID) entity.getId(), entity);
        }
        return Optional.of(entity);
    }

    public boolean delete(ID id) {
        Optional<T> optinalEntity = this.findById(id);
        if (optinalEntity.isPresent()) {
            memoryDatabase.remove(id);
            return true;
        }
        return false;
    }

    private Integer handleNextId() {
        return sequenceGenerator.getAndIncrement();
    }

}
