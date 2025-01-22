package com.jve.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jve.entity.Product;
import com.jve.repository.ProductRepository;



@Controller
@RequestMapping("/products")
public class ProductController {

	private final ProductRepository repository;

	//Inyecta por el constructor
	public ProductController(ProductRepository repository) {
		this.repository = repository;
	}

	/*
	GET http://localhost:9000/products
	*/
	@GetMapping
	public String findAll(Model model) {
		List<Product> products = this.repository.findAll();
		model.addAttribute("product", products);
		return "product-list";
	}

	/*
	GET http://localhost:9000/products/new
	*/
	@GetMapping("/new")
	public String getForm(Model model) {
		model.addAttribute("product", new Product());
		return "product-form";
	}

	/*
	POST http://localhost:9000/products
	*/
	@PostMapping
	public String save(@ModelAttribute("product") Product product) {
		this.repository.save(product);
		return "redirect:/products";
	}

	/*
	GET http://localhost:9000/products/{id}/view
	*/
	@GetMapping("/{id}/view")
	public String viewProduct(Model model, @PathVariable Long id) {
		Optional<Product> product = this.repository.findById(id);
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
			return "product-view";
		} else {
			return "redirect:/products";
		}
	}

	/*
	GET http://localhost:9000/products/{id}/edit
	*/
	@GetMapping("/{id}/edit")
	public String editForm(Model model, @PathVariable Long id) {
		Optional<Product> product = this.repository.findById(id);
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
			return "product-form";
		} else {
			return "redirect:/products";
		}
	}

	/*
	GET http://localhost:9000/products/{id}/delete
	*/
	@GetMapping("/{id}/delete")
	public String deleteProduct(@PathVariable Long id) {
		Optional<Product> product = this.repository.findById(id);
		if (product.isPresent()) {
			this.repository.deleteById(id);
		}
		return "redirect:/products";
	}
	

}
