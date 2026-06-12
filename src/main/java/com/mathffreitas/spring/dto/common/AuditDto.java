package com.mathffreitas.spring.dto.common;

import java.time.LocalDateTime;

public record AuditDto(
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
