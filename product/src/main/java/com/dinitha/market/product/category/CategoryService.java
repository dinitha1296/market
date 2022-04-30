package com.dinitha.market.product.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> listAll() {
		return categoryRepository.findAll();
	}
	
	public Category getCategory(long id) {
		return categoryRepository.findById(id).get();
	}
}
