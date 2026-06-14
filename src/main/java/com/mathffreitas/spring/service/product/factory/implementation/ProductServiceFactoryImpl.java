package com.mathffreitas.spring.service.product.factory.implementation;

import com.mathffreitas.spring.service.product.ProductService;
import com.mathffreitas.spring.service.product.factory.ProductServiceFactory;
import com.mathffreitas.spring.utils.versioning.version.ApiVersions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProductServiceFactoryImpl implements ProductServiceFactory {
    private final Map<ApiVersions, ProductService> services;

    public ProductServiceFactoryImpl(
            @Qualifier("productServiceV1") ProductService v1, // here is where is defined which implementation version will be used
            @Qualifier("productServiceV2") ProductService v2, // here is where is defined which implementation version will be used
            @Qualifier("productServiceV3") ProductService v3
    ) {
        this.services = Map.of(
                ApiVersions.V1, v1,
                ApiVersions.V2, v2,
                ApiVersions.V3, v3
        );
    }

    @Override
    public ProductService forVersion(ApiVersions version) {
        return this.services.get(version);
    }
}
