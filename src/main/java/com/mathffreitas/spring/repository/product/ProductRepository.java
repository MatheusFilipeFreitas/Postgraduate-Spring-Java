package com.mathffreitas.spring.repository.product;

import com.mathffreitas.spring.model.product.Product;
import com.mathffreitas.spring.repository.common.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository extends CrudRepository<Product, Integer> {

}
