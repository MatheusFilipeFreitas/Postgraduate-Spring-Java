package com.mathffreitas.spring.dto.product.request;

import java.math.BigDecimal;

public record ProductCreateDto(
        String name,
        BigDecimal price
) {
}
