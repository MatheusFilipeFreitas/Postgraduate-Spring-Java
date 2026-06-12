package com.mathffreitas.spring.dto.product.response;

import com.mathffreitas.spring.dto.common.AuditDto;

import java.math.BigDecimal;

public record ProductResponseDto(
        Integer id,
        String name,
        BigDecimal price,
        AuditDto audit
) {
}
