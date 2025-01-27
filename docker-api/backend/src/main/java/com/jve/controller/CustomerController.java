package com.jve.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jve.entity.Product;
import com.jve.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class CustomerController {

	private final ProductRepository repository;

	public CustomerController(ProductRepository repository) {
		this.repository =  repository;
	}

	@GetMapping
	public List<Product> findAll() {
		return repository.findAll();
	}
}
