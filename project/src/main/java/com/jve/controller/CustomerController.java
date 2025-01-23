package com.jve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jve.entity.Product;

@RestController
@RequestMapping("/api/products")
public class CustomerController {

	@GetMapping("/{id}")
	public Product findById(@PathVariable Long id) {
		return new Product(id, "productApi", 4.55, 5);
	}
}
