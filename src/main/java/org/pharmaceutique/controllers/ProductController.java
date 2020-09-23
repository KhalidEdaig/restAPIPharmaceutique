package org.pharmaceutique.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.pharmaceutique.models.Product;
import org.pharmaceutique.repositries.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/products")
	public ResponseEntity<Object> createStudent(@RequestBody Product product) {
		Product savedProduct = productRepository.save(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getId()).toUri();
		return ResponseEntity.created(location).build();

	}
	// the method to expose the details of all products.
	@GetMapping("/products")
	public List<Product> retrieveAllProducts() {
		return productRepository.findAll();
	}
	// method to expose the details of a specific product by code.
	@GetMapping("/products/{code}")
	public Product retrieveProdectByCode(@PathVariable String code) {
		Optional<Product> product = productRepository.findByCodeContaining(code);
		//Exception if not exist	
		return product.get();
	}
	// method to expose the details of a specific product by nom
	@GetMapping("/products/{name}")
	public Product retrieveProdectByName(@PathVariable String name) {
		Optional<Product> product = productRepository.findByNomContaining(name);
		//Exception if not exist	
		return product.get();
	}
	//Delete method is simple
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable long id) {
		productRepository.deleteById(id);
	}
	
	

}
