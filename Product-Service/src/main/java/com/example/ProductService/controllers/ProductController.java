package com.example.ProductService.controllers;
import com.example.ProductService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @LoadBalanced
    @Bean
    private RestTemplate restTemplate(){
      return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/search")
    public Product getProductsByTypeAndName(@RequestParam(value = "sku") final String sku) {
      String url = "http://PRICING-SERVICE/products/price?sku=" + sku;
      String price = restTemplate.getForObject(url, String.class);
      // return price;
      return new Product(sku, price);
      // return restTemplate.getForObject(url, Product.class);
    }
}

