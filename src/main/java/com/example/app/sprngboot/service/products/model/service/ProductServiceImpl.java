package com.example.app.sprngboot.service.products.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.sprngboot.service.products.model.entity.Product;
import com.example.app.sprngboot.service.products.model.repository.ProductDao;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductDao productDAO;
	
	@Override	
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		
		return (List<Product>) productDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long productId) {
		
		return productDAO.findById(productId).orElse(null);
	}
	
}
