package com.mathffreitas.spring.service.product.implementation;

import com.mathffreitas.spring.dto.product.request.ProductCreateDto;
import com.mathffreitas.spring.dto.product.request.ProductUpdateDto;
import com.mathffreitas.spring.dto.product.response.ProductResponseDto;
import com.mathffreitas.spring.model.product.Product;
import com.mathffreitas.spring.repository.product.ProductRepository;
import com.mathffreitas.spring.service.product.ProductService;
import com.mathffreitas.spring.utils.mapper.product.request.ProductCreateMapper;
import com.mathffreitas.spring.utils.mapper.product.request.ProductUpdateMapper;
import com.mathffreitas.spring.utils.mapper.product.response.ProductResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductCreateMapper createMapper;
    private final ProductUpdateMapper updateMapper;
    private final ProductResponseMapper responseMapper;
    private final ProductRepository repository;

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
}
