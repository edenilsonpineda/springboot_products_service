package com.example.app.sprngboot.service.products.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.app.sprngboot.service.products.model.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long>{
	//Creating a repository from Entity Products
	
}
