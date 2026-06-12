package com.mathffreitas.spring.service.common;

import java.util.List;
import java.util.Optional;

public interface CrudService<
        CreateDto,
        UpdateDto,
        ResponseDto,
        ID> {

    ResponseDto create(CreateDto dto);

    Optional<ResponseDto> findById(ID id);

    List<ResponseDto> findAll();

    Optional<ResponseDto> update(ID id, UpdateDto dto);

    boolean delete(ID id);
}
