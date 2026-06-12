package com.mathffreitas.spring.repository.product;

import com.mathffreitas.spring.model.product.Product;
import com.mathffreitas.spring.repository.common.implementation.CrudRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends CrudRepositoryImpl<Product, Integer> {
    // this repository is a class to extend the memory crud repository
}
