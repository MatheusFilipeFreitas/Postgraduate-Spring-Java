package com.mathffreitas.spring.service.product.implementation;

import com.mathffreitas.spring.repository.product.ProductRepository;
import com.mathffreitas.spring.utils.mapper.product.request.ProductCreateToEntityMapper;
import com.mathffreitas.spring.utils.mapper.product.request.ProductUpdateToEntityMapper;
import com.mathffreitas.spring.utils.mapper.product.response.ProductResponseToDtoMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("productServiceV2")
/*
    Qualifier:
    Used to handle versioning of service so when called. You can specify which
    implementation the class will call by adding the target qualifier in the class
    that is calling this service.
 */
public class ProductServiceImplV2 extends ProductServiceImplV1 {
    public ProductServiceImplV2(ProductCreateToEntityMapper createMapper, ProductUpdateToEntityMapper updateMapper, ProductResponseToDtoMapper responseMapper, ProductRepository repository) {
        super(createMapper, updateMapper, responseMapper, repository);
    }

    @Override
    public BigDecimal getTotalPrices() {
        return this.repository.getTotalPrices();
    }
}
