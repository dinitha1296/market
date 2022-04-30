package com.dinitha.market.product.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dinitha.market.product.util.CustomPageRequest;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Page<Product> listAll(Integer pageNumber, Integer pageSize) {
		return productRepository.findAll(CustomPageRequest.of(pageNumber, pageSize));
	}
	
	public Page<Product> listProductsByDepartmentId(Long departmentId, Integer pageNumber, Integer pageSize) {
		return productRepository.findByDepartmentId(departmentId, CustomPageRequest.of(pageNumber, pageSize));
	}
	
	public Page<Product> listProductsBySubDepartmentId(Long subDepartmentId, Integer pageNumber, Integer pageSize) {
		return productRepository.findBySubDepartmentId(subDepartmentId, CustomPageRequest.of(pageNumber, pageSize));
	}
	
	public Page<Product> listProductsByCategoryId(Long subDepartmentId, Integer pageNumber, Integer pageSize) {
		return productRepository.findByCategoryId(subDepartmentId, CustomPageRequest.of(pageNumber, pageSize));
	}
	
	public Page<Product> listProductsBySearchQuery(String query, Integer pageNumber, Integer pageSize) {
		String regexPattern = List.of(query.replaceAll("[^a-zA-Z\\s]", "").split(" "))
				.stream().reduce("", (p, w) -> p + "(?=.*" + w + ")");
//		System.out.println(regexPattern);
		return productRepository.findByRegexMatching(regexPattern, CustomPageRequest.of(pageNumber, pageSize));
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
