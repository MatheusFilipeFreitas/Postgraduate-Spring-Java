package com.mathffreitas.spring.service.product.implementation;

import com.mathffreitas.spring.dto.product.request.ProductCreateDto;
import com.mathffreitas.spring.dto.product.request.ProductUpdateDto;
import com.mathffreitas.spring.dto.product.response.ProductResponseDto;
import com.mathffreitas.spring.model.error.NotAvailableContentException;
import com.mathffreitas.spring.model.product.Product;
import com.mathffreitas.spring.repository.product.ProductRepository;
import com.mathffreitas.spring.service.product.ProductService;
import com.mathffreitas.spring.utils.mapper.product.request.ProductCreateMapper;
import com.mathffreitas.spring.utils.mapper.product.request.ProductUpdateMapper;
import com.mathffreitas.spring.utils.mapper.product.response.ProductResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productServiceV2")
/*
    Qualifier:
    Used to handle versioning of service so when called. You can specify which
    implementation the class will call by adding the target qualifier in the class
    that is calling this service.
 */
@RequiredArgsConstructor
public class ProductServiceImplV2 implements ProductService {
    private final ProductCreateMapper createMapper;
    private final ProductUpdateMapper updateMapper;
    private final ProductResponseMapper responseMapper;
    private final ProductRepository repository;

    private final String ERROR_MESSAGE = "V2 is currently in development...";

    @Override
    public ProductResponseDto create(ProductCreateDto productCreateDto) {
        throw new NotAvailableContentException(ERROR_MESSAGE);
    }

    @Override
    public Optional<ProductResponseDto> findById(Integer integer) {
        throw new NotAvailableContentException(ERROR_MESSAGE);
    }

    @Override
    public List<ProductResponseDto> findAll() {
        throw new NotAvailableContentException(ERROR_MESSAGE);
    }

    @Override
    public Optional<ProductResponseDto> update(Integer id, ProductUpdateDto productUpdateDto) {
        throw new NotAvailableContentException(ERROR_MESSAGE);
    }

    @Override
    public boolean delete(Integer integer) {
        throw new RuntimeException(ERROR_MESSAGE);
    }
}
