package com.epicminds.jwttokenauth.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.epicminds.jwttokenauth.demo.model.Product;
import com.epicminds.jwttokenauth.demo.repo.ProductRepository;
import com.epicminds.jwttokenauth.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

}
