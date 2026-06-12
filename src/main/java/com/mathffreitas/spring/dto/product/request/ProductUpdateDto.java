package com.mathffreitas.spring.dto.product.request;

import java.math.BigDecimal;

public record ProductUpdateDto(
        Integer id,
        String name,
        BigDecimal price
) {
}
