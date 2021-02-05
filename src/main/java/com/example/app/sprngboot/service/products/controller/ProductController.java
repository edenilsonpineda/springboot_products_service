package com.example.app.sprngboot.service.products.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.sprngboot.service.products.model.service.IProductService;
import com.example.app.sprngboot.service.products.model.entity.Product;


@RestController
public class ProductController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/products")
	public List<Product> list(){
		return productService.findAll().stream().map(product -> {
				product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
				return product;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/products/{id}")
	public Product detailOfProduct(@PathVariable Long id) {
		Product product = productService.findById(id);
		product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return productService.findById(id);
	}
}
