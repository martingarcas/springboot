package com.jve;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jve.entity.Product;
import com.jve.repository.ProductRepository;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		ProductRepository repository = context.getBean(ProductRepository.class);

		List<Product> products = List.of(
			new Product(null, "product1", 5.99, 1),
			new Product(null, "product2", 7.99, 2),
			new Product(null, "product3", 2.99, 3),
			new Product(null, "product4", 10.99, 3),
			new Product(null, "product5", 8.99, 8),
			new Product(null, "product6", 5.99, 10)
		);

		repository.saveAll(products);
	}

}
