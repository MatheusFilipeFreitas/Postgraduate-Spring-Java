package com.mathffreitas.spring.utils.mapper.common;

public interface DtoToEntityMapper<Entity, DTO> {
    Entity toEntity(DTO dto) throws NoSuchMethodException;

}
