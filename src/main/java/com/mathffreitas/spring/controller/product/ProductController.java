package com.mathffreitas.spring.controller.product;

import com.mathffreitas.spring.controller.common.CrudController;
import com.mathffreitas.spring.dto.product.request.ProductCreateDto;
import com.mathffreitas.spring.dto.product.request.ProductUpdateDto;
import com.mathffreitas.spring.dto.product.response.ProductResponseDto;
import com.mathffreitas.spring.service.common.CrudService;
import com.mathffreitas.spring.service.product.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController extends CrudController<
        ProductCreateDto,
        ProductUpdateDto,
        ProductResponseDto,
        Integer> {

    private final ProductService service;

    public ProductController(
            @Qualifier("productServiceV2")
            // here is where is defined which implementation version will be used
            ProductService productService
    ) {
        this.service = productService;
    }

    @Override
    protected CrudService<
            ProductCreateDto,
            ProductUpdateDto,
            ProductResponseDto,
            Integer> getService() {
        return this.service;
    }
}
