package com.dinitha.market.product.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Category> getCategorys() {
		return categoryService.listAll();
	}
	
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable Long id) {
		return categoryService.getCategory(id);
	}
}
