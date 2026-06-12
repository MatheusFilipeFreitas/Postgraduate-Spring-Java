package com.mathffreitas.spring.model.product;

import com.mathffreitas.spring.model.common.BaseIdModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//@SuperBuilder -> (recommended for inheritance) generates a builder patter
/*
    Turns out like this:
    Product product = Product.builder()
    .id(1)
    .name("Book")
    .price(BigDecimal.TEN)
    .build();
 */

@Getter
@Setter
public class Product extends BaseIdModel {
    private String name;
    private BigDecimal price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(Integer id, String name, BigDecimal price) {
        super(id);
        this.name = name;
        this.price = price;
    }
}
