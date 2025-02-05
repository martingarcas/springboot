package com.jve.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jve.entity.Category;
import com.jve.repository.CategoryRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryRepository repository;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = repository.findAll();
        return categories.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(categories); // Devuelve 204 si está vacío
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok) // Si se encuentra la categoría, devuelve 200 OK con la categoría
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encuentra, devuelve 404 Not Found
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        if (category.getName() == null) {
            return ResponseEntity.badRequest().build();
        }
        Category savedCategory = repository.save(category);
        return ResponseEntity.status(201).body(savedCategory);
    }
    
	
}
