package com.mathffreitas.spring.utils.mapper.product.request;

import com.mathffreitas.spring.dto.product.request.ProductCreateDto;
import com.mathffreitas.spring.utils.mapper.common.DtoToEntityMapper;
import com.mathffreitas.spring.model.product.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductCreateToEntityMapper implements DtoToEntityMapper<Product, ProductCreateDto> {

    @Override
    public Product toEntity(ProductCreateDto productCreateDto) throws NoSuchMethodException {
        Product product = new Product(
                null,
                productCreateDto.name(),
                productCreateDto.price()
        );
        product.setCreatedAt(LocalDateTime.now()); //only because this is in memory
        return product;
    }
}
