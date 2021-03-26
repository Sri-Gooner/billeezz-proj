package com.mycomp.billeezz.userservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.billeezz.userservice.ProductProxy;
import com.mycomp.billeezz.userservice.DTO.Product;

@RestController
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	ProductProxy proxy;
	
	@GetMapping("/")
	public String getBaseScreen(HttpServletRequest request){
		logger.info("User.getBaseScreen -> {}"+request);
		return "Hello";
	}
	
	@GetMapping("/listProducts")
	public List<Product> listProducts(HttpServletRequest request){
		logger.info("User.listProducts -> {}"+request);
		return proxy.listProducts();
	}
	
	@GetMapping("/searchProducts/{productName}")
	public List<Product> searchProducts(HttpServletRequest request, @PathVariable("productName") String prdName){
		logger.info("User.searchProducts -> {}"+request);
		return proxy.searchProducts(prdName);
	}
	
	
	
	
}
