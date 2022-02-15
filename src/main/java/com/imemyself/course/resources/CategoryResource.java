package com.imemyself.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.imemyself.course.domain.Category;
import com.imemyself.course.service.CategoryService;

@RestController
@RequestMapping(value = "/Categories")
public class CategoryResource {

	@Autowired
	private CategoryService CategoryService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> listCategory = CategoryService.findAll();
		return ResponseEntity.ok().body(listCategory);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category Category = CategoryService.findById(id);
		return ResponseEntity.ok().body(Category);
	}
}
