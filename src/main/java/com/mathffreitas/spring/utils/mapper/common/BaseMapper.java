package com.mathffreitas.spring.utils.mapper.common;

public interface BaseMapper<Entity, DTO> {
    Entity toEntity(DTO dto) throws NoSuchMethodException;
    DTO toDto(Entity entity) throws NoSuchMethodException;
}
