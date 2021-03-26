package com.mycomp.billeezz.productservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

import com.mycomp.billeezz.productservice.DTO.Product;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@Bean
	public Sampler getAlwaysSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@Bean
	public List<Product> getProdcutList(){
		List<Product> products = new ArrayList<Product>();
		Product product;
		for(int i=0;i<10;i++){
			product = new Product();
			product.setId(""+i);
			product.setProductName("productName - "+i);
			product.setQuantity("quantity - "+i);
			product.setImagePath("imagePath -"+i);
			product.setCost("cost - "+i);
			products.add(product);
		}
		return products;
	}

}
