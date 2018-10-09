package com.example.ProductService.services;

import com.example.ProductService.models.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @LoadBalanced
    @Bean
    private RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "reliable")
    public Product getPrice(String sku) {
        String url = "http://PRICING-SERVICE/products/price?sku=" + sku;
        String price = restTemplate.getForObject(url, String.class);
        return new Product(sku, price);
    }

    public Product reliable(String sku) {
        return new Product("Default", "0");
    }


}
