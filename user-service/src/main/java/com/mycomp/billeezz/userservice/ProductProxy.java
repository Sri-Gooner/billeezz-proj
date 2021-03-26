package com.mycomp.billeezz.userservice;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mycomp.billeezz.userservice.DTO.Product;

//@FeignClient(name="billeezz-product-service")
@FeignClient(name="zuul-api-server")
@RibbonClient(name="billeezz-product-service")
public interface ProductProxy {
	@GetMapping("/billeezz-product-service/listProducts")
	public List<Product> listProducts();
	
	@GetMapping("/billeezz-product-service/searchProducts/{productName}")
	public List<Product> searchProducts(@PathVariable("productName") String productName);
}
