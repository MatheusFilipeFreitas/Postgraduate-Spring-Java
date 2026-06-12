package com.mathffreitas.spring.dto.product.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public record ProductUpdateDto(
        @JsonIgnore Integer id,
        String name,
        BigDecimal price
) {
}
