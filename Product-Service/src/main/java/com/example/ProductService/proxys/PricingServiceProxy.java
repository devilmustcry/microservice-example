package com.example.ProductService.proxys;

import com.example.ProductService.models.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="pricing-service")
@RibbonClient(name="pricing-service")
public interface PricingServiceProxy {

    @RequestMapping("/products/price")
    public String findPrice(@RequestParam(value="sku") String sku);

}
