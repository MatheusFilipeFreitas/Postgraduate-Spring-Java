package com.mathffreitas.spring.service.product;

import com.mathffreitas.spring.dto.product.request.ProductCreateDto;
import com.mathffreitas.spring.dto.product.request.ProductUpdateDto;
import com.mathffreitas.spring.dto.product.response.ProductResponseDto;
import com.mathffreitas.spring.service.common.CrudService;

public interface ProductService extends CrudService<
        ProductCreateDto,
        ProductUpdateDto,
        ProductResponseDto,
        Integer> {
}
