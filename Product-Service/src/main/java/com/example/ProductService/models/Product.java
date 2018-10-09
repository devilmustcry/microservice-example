package com.example.ProductService.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class Product {
    private String sku;
    private String price;

    public Product(String sku, String price) {
        this.sku = sku;
        this.price = price;
    }
}
