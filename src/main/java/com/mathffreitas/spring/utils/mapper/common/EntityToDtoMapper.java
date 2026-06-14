package com.mathffreitas.spring.utils.mapper.common;

public interface EntityToDtoMapper<Entity, DTO> {
    DTO toDto(Entity entity) throws NoSuchMethodException;
}
