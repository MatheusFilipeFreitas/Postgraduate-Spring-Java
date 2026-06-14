package com.mathffreitas.spring.utils.mapper.product.response;

import com.mathffreitas.spring.dto.common.AuditDto;
import com.mathffreitas.spring.dto.product.response.ProductResponseDto;
import com.mathffreitas.spring.utils.mapper.common.EntityToDtoMapper;
import com.mathffreitas.spring.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseToDtoMapper implements EntityToDtoMapper<Product, ProductResponseDto> {

    @Override
    public ProductResponseDto toDto(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                new AuditDto(product.getCreatedAt(), product.getUpdatedAt())
        );
    }
}
