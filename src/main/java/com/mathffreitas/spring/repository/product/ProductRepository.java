package com.mathffreitas.spring.repository.product;

import com.mathffreitas.spring.model.product.Product;
import com.mathffreitas.spring.repository.common.implementation.CrudRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class ProductRepository extends CrudRepositoryImpl<Product, Integer> {
    // this repository is a class to extend the memory crud repository
    public BigDecimal getTotalPrices() {
        return this.memoryDatabase.values().stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
