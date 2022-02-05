package com.dinitha.market.product.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listAll() {
		return productRepository.findAll();
	}
	
	public List<Product> listProductsByDepartmentId(Long departmentId) {
		return productRepository.findByDepartmentId(departmentId);
	}
	
	public List<Product> listProductsBySubDepartmentId(Long subDepartmentId) {
		return productRepository.findBySubDepartmentId(subDepartmentId);
	}
	
	public List<Product> listProductsByCategoryId(Long subDepartmentId) {
		return productRepository.findByCategoryId(subDepartmentId);
	}
	
	public List<Product> listProductsBySearchQuery(String query) {
		String regexPattern = List.of(query.replaceAll("[^a-zA-Z\\s]", "").split(" "))
				.stream().reduce("", (p, w) -> p + "(?=.*" + w + ")");
		System.out.println(regexPattern);
		return productRepository.findByRegexMatching(regexPattern);
	}
	
	public Product getProduct(Long id) {
		return productRepository.findById(id).get();
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
