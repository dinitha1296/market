package com.dinitha.market.product.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts(
			@RequestParam(required = false) String query
		) {
		if (query != null) return productService.listProductsBySearchQuery(query);
		return productService.listAll();
	}

	@GetMapping(params = {"department-id"})
	public List<Product> getProductsByDepartmentId(@RequestParam Long departmentId) {
		return productService.listProductsByDepartmentId(departmentId);
	}
	
	@GetMapping(params = {"sub-department-id"})
	public List<Product> getProductsBySubDepartmentId(@RequestParam Long subDepartmentId) {
		return productService.listProductsBySubDepartmentId(subDepartmentId);
	}
	
	@GetMapping(params = {"category-id"})
	public List<Product> getProductsByCategoryId(@RequestParam Long categoryId) {
		return productService.listProductsByCategoryId(categoryId);
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
