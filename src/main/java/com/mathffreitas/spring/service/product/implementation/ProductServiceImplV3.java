package com.mathffreitas.spring.service.product.implementation;

import com.mathffreitas.spring.dto.product.request.ProductCreateDto;
import com.mathffreitas.spring.dto.product.request.ProductUpdateDto;
import com.mathffreitas.spring.dto.product.response.ProductResponseDto;
import com.mathffreitas.spring.model.error.NotAvailableContentException;
import com.mathffreitas.spring.service.product.ProductService;
import com.mathffreitas.spring.utils.constant.error.ErrorMessage;
import com.mathffreitas.spring.utils.versioning.version.ApiVersions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service("productServiceV3")

@RequiredArgsConstructor
public class ProductServiceImplV3 implements ProductService {
    private final String ERROR_MESSAGE = ApiVersions.V3.name() + " " + ErrorMessage.VERSION_IN_DEVELOPMENT;

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
        throw new NotAvailableContentException(ERROR_MESSAGE);
    }

    @Override
    public BigDecimal getTotalPrices() {
        throw new NotAvailableContentException(ERROR_MESSAGE);
    }
}
