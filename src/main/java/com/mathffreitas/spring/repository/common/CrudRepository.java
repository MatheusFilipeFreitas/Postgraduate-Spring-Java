package com.mathffreitas.spring.repository.common;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    Optional<T> findById(ID id);
    List<T> findAll();
    T save(T entity);
    Optional<T> update(T entity);
    boolean delete(ID id);
}
