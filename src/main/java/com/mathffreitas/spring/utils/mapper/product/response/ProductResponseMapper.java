package com.mathffreitas.spring.utils.mapper.product.response;

import com.mathffreitas.spring.dto.common.AuditDto;
import com.mathffreitas.spring.dto.product.response.ProductResponseDto;
import com.mathffreitas.spring.utils.mapper.common.BaseMapper;
import com.mathffreitas.spring.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapper implements BaseMapper<Product, ProductResponseDto> {

    @Override
    public Product toEntity(ProductResponseDto productResponseDto) throws NoSuchMethodException {
        throw new NoSuchMethodException("Not implemented!");
    }

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
