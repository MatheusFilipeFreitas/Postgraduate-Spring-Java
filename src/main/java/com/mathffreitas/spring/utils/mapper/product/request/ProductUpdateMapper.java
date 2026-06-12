package com.mathffreitas.spring.utils.mapper.product.request;

import com.mathffreitas.spring.dto.product.request.ProductUpdateDto;
import com.mathffreitas.spring.utils.mapper.common.BaseMapper;
import com.mathffreitas.spring.model.product.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductUpdateMapper implements BaseMapper<Product, ProductUpdateDto> {
    @Override
    public Product toEntity(ProductUpdateDto productUpdateDto) throws NoSuchMethodException {
        Product product = new Product(
                productUpdateDto.id(),
                productUpdateDto.name(),
                productUpdateDto.price()
        );
        product.setUpdatedAt(LocalDateTime.now()); //only because this is in memory
        return product;
    }

    @Override
    public ProductUpdateDto toDto(Product product) throws NoSuchMethodException {
        throw new NoSuchMethodException("Not implemented.");
    }
}
