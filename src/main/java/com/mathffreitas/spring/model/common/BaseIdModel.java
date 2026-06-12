package com.mathffreitas.spring.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@SuperBuilder -> (recommended for inheritance) generates a builder patter
@AllArgsConstructor

@Getter
@Setter
public abstract class BaseIdModel {
    protected Integer id;
}
