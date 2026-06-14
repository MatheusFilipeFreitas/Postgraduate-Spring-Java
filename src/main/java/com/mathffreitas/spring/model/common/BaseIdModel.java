package com.mathffreitas.spring.model.common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseIdModel {
    protected Integer id;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    protected BaseIdModel() {
    }

    public BaseIdModel(Integer id) {
        this.id = id;
    }
}
