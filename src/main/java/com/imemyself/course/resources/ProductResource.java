package com.imemyself.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.imemyself.course.domain.Product;
import com.imemyself.course.service.ProductService;

@RestController
@RequestMapping(value = "/Products")
public class ProductResource {

	@Autowired
	private ProductService ProductService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> listProduct = ProductService.findAll();
		return ResponseEntity.ok().body(listProduct);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product Product = ProductService.findById(id);
		return ResponseEntity.ok().body(Product);
	}
}
