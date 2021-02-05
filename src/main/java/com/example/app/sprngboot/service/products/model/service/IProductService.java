package com.example.app.sprngboot.service.products.model.service;

import java.util.List;

import com.example.app.sprngboot.service.products.model.entity.Product;

public interface IProductService {
	
	public List<Product> findAll();
	
	public Product findById(Long productId);
}
