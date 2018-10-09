package com.example.PricingService.controllers;

// import com.example.PricingService.models.Price;

import lombok.Data;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products/price")
@RefreshScope
public class PricingController {
    @Value("${product.price}")
    String productPrice;

    @GetMapping
    public String getPrice(@RequestParam(value = "sku") final String sku) {
        Price price = new Price();
        price.setSku(sku);
        price.setPrice(productPrice);
        return productPrice;
    }
    class Price {
        private String sku;
        private String price;
    
        public Price() {
    
        }
    
        public Price(String sku, String price) {
            this.sku = sku;
            this.price = price;
        }
    
        public void setSku(String sku) {
            this.sku = sku;
        }
    
        public void setPrice(String price) {
            this.price = price;
        }
    }
}