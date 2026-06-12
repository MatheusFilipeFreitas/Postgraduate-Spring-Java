package com.mathffreitas.spring.controller.common;

import com.mathffreitas.spring.service.common.CrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public abstract class CrudController<
        CreateDto,
        UpdateDto,
        ResponseDto,
        ID> {

    protected abstract CrudService<
                    CreateDto,
                    UpdateDto,
                    ResponseDto,
                    ID> getService();

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(
            @PathVariable ID id) {

        return getService()
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ResponseDto>> findAll() {
        return ResponseEntity.ok(
                getService().findAll());
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(
            @RequestBody CreateDto dto) {

        ResponseDto response =
                getService().create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable ID id,
            @RequestBody UpdateDto dto) {

        return getService()
                .update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable ID id) {

        boolean deleted =
                getService().delete(id);

        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}