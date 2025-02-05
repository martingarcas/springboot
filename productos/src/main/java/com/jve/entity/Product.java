package com.jve.entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private Double price;
	private Integer quantity;

	// Relación muchos a muchos con Category
    @ManyToMany
    @JoinTable(
        name = "product_category", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonBackReference // Evitar serialización circular desde el lado de Product
    private List<Category> categories;

	public Product() { }

	public Product(Long id, String title, Double price, Integer quantity, List<Category> categories) {

		this.id 		= id;
		this.title 		= title;
		this.price 		= price;
		this.quantity 	= quantity;
		this.categories = categories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

	@Override
	public String toString() {
		return id + " - " + title + " - " + price + " - " + quantity;
	}

}
