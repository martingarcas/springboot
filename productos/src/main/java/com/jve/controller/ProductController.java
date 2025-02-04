package com.jve.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jve.entity.Product;
import com.jve.repository.ProductRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = repository.findAll();
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products); // Devuelve 204 si está vacío
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok) // Si se encuentra el producto, devuelve 200 OK con el producto
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encuentra, devuelve 404 Not Found
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        if (product.getTitle() == null || product.getPrice() == null) { // Validación básica
            return ResponseEntity.badRequest().build(); // Devuelve 400 Bad Request si los datos no son válidos
        }
        Product savedProduct = repository.save(product);
        return ResponseEntity.status(201).body(savedProduct); // Devuelve 201 Created con el producto guardado
    }
}
