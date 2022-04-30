package com.dinitha.market.product.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	public Page<Product> getAllProducts(
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "page-number", required = false) Integer pageNumber,
			@RequestParam(name = "page-size", required = false) Integer pageSize
		) {
		if (query != null) return productService.listProductsBySearchQuery(query, pageNumber, pageSize);
		return productService.listAll(pageNumber, pageSize);
	}

	@GetMapping(params = {"department-id"})
	public Page<Product> getProductsByDepartmentId(
			@RequestParam(name = "department-id") Long departmentId,
			@RequestParam(name = "page-number", required = false) Integer pageNumber,
			@RequestParam(name = "page-size", required = false) Integer pageSize
		) {
		return productService.listProductsByDepartmentId(departmentId, pageNumber, pageSize);
	}
	
	@GetMapping(params = {"sub-department-id"})
	public Page<Product> getProductsBySubDepartmentId(
			@RequestParam(name = "sub-department-id") Long subDepartmentId,
			@RequestParam(name = "page-number", required = false) Integer pageNumber,
			@RequestParam(name = "page-size", required = false) Integer pageSize
		) {
		return productService.listProductsBySubDepartmentId(subDepartmentId, pageNumber, pageSize);
	}
	
	@GetMapping(params = {"category-id"})
	public Page<Product> getProductsByCategoryId(
			@RequestParam(name = "category-id") Long categoryId,
			@RequestParam(name = "page-number", required = false) Integer pageNumber,
			@RequestParam(name = "page-size", required = false) Integer pageSize
		) {
		return productService.listProductsByCategoryId(categoryId, pageNumber, pageSize);
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
