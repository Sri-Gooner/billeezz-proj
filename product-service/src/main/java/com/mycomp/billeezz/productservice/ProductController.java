package com.mycomp.billeezz.productservice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.billeezz.productservice.DTO.Product;

@RestController
public class ProductController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	List<Product> products;
	
	@Autowired
	Environment environment;

	@GetMapping("/listProducts")
	public List<Product> listProducts(HttpServletRequest request){
		logger.info("listProducts -> {}"+request);
		String port = environment.getProperty("local.server.port");
		products.get(0).setPort(port);
		return products;
	}
	@GetMapping("/searchProducts/{productName}")
	public List<Product> searchProducts(HttpServletRequest request, @PathVariable("productName") String prdName){
		logger.info("searchProducts -> {}"+request);
		String port = environment.getProperty("local.server.port");
		System.out.println("Searched Product Name - "+prdName);
		List<Product> searchList = new ArrayList<Product>();
		searchList.add(new Product());
		for(Product prd : products){
			if(prd.getProductName().contains(prdName)){
				searchList.add(prd);
			}
		}
		searchList.get(0).setPort(port);
		return searchList;
	}
}
