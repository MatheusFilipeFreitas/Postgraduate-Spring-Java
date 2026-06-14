package com.mathffreitas.spring.service.product.implementation;

import com.mathffreitas.spring.dto.product.request.ProductCreateDto;
import com.mathffreitas.spring.dto.product.request.ProductUpdateDto;
import com.mathffreitas.spring.dto.product.response.ProductResponseDto;
import com.mathffreitas.spring.model.error.NotAvailableContentException;
import com.mathffreitas.spring.model.product.Product;
import com.mathffreitas.spring.repository.product.ProductRepository;
import com.mathffreitas.spring.service.product.ProductService;
import com.mathffreitas.spring.utils.constant.error.ErrorMessage;
import com.mathffreitas.spring.utils.mapper.product.request.ProductCreateToEntityMapper;
import com.mathffreitas.spring.utils.mapper.product.request.ProductUpdateToEntityMapper;
import com.mathffreitas.spring.utils.mapper.product.response.ProductResponseToDtoMapper;
import com.mathffreitas.spring.utils.versioning.version.ApiVersions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service("productServiceV1")
/*
    Qualifier:
    Used to handle versioning of service so when called. You can specify which
    implementation the class will call by adding the target qualifier in the class
    that is calling this service.
 */
@RequiredArgsConstructor
public class ProductServiceImplV1 implements ProductService {
    protected final ProductCreateToEntityMapper createMapper;
    protected final ProductUpdateToEntityMapper updateMapper;
    protected final ProductResponseToDtoMapper responseMapper;
    protected final ProductRepository repository;

    @Override
    public ProductResponseDto create(ProductCreateDto productCreateDto) {
        try {
            Product entity = createMapper.toEntity(productCreateDto);
            return responseMapper.toDto(this.repository.save(entity));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Optional<ProductResponseDto> findById(Integer integer) {
        try {
            Optional<Product> optionalProduct = this.repository.findById(integer);
            return optionalProduct.map(responseMapper::toDto);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return this.repository.findAll().stream().map(responseMapper::toDto).toList();
    }

    @Override
    public Optional<ProductResponseDto> update(Integer id, ProductUpdateDto productUpdateDto) {
        try {
            Product entity = updateMapper.toEntity(new ProductUpdateDto(
                    id,
                    productUpdateDto.name(),
                    productUpdateDto.price())
            );

            Optional<Product> optionalProduct = this.repository.update(entity);
            return optionalProduct.map(responseMapper::toDto);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean delete(Integer integer) {
        return this.repository.delete(integer);
    }

    @Override
    public BigDecimal getTotalPrices() {
        throw new NotAvailableContentException(ErrorMessage.NO_AVAILABLE_CONTENT_FOR_VERSION + ApiVersions.V2.name());
    }
}
