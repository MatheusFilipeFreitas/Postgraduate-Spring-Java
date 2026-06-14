package com.mathffreitas.spring.controller.product;

import com.mathffreitas.spring.controller.common.CrudController;
import com.mathffreitas.spring.dto.product.request.ProductCreateDto;
import com.mathffreitas.spring.dto.product.request.ProductUpdateDto;
import com.mathffreitas.spring.dto.product.response.ProductResponseDto;
import com.mathffreitas.spring.service.common.CrudService;
import com.mathffreitas.spring.service.product.ProductService;
import com.mathffreitas.spring.service.product.factory.ProductServiceFactory;
import com.mathffreitas.spring.utils.versioning.ApiVersionResolver;
import com.mathffreitas.spring.utils.versioning.version.ApiVersions;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@AllArgsConstructor

@RestController
@RequestMapping("/v{apiVersion}/products")
public class ProductController extends CrudController<
        ProductCreateDto,
        ProductUpdateDto,
        ProductResponseDto,
        Integer> {
    private final ProductServiceFactory productServiceFactory;
    private final ApiVersionResolver apiVersionResolver;
    private final HttpServletRequest request;

    @Override
    protected ProductService getService() {
        ApiVersions apiVersion = apiVersionResolver.resolve(request);
        return productServiceFactory.forVersion(apiVersion);
    }

    @GetMapping("total-prices")
    public ResponseEntity<BigDecimal> totalPrices() {
        return ResponseEntity.ok(this.getService().getTotalPrices());
    }
}
