package com.dinitha.market.product.category;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryRepositoryTests {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test 
	@Order(1)
	public void testRepositoryAutowiring() {
		assertThat(categoryRepository).isNotNull();
	}
	
	@Test
	@Rollback(false)
	@Order(2)
	public void testCategoryCreation() {
		
		Category category = Category.builder()
				.categoryName("Category")
				.categoryCode("DSDCT")
				.build();
		
		categoryRepository.save(category);
		assertThat(category.getCategoryId()).isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testCategoryListFetch() {
		
		List<Category> categoryList =  categoryRepository.findAll();
		
		assertThat(categoryList).isNotNull();
		assertThat(categoryList.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	public void testCategoryFetchById() {
		
		Optional<Category> category = categoryRepository.findById(1L);
		
		assertThat(category).isNotNull();
		assertThat(category.isPresent());
		assertThat(category.get().getCategoryId()).isEqualTo(1L);
	}
	
	@Test
	@Order(5)
	@Rollback(false)
	public void testCategoryUpdate() {
		
		Category category = categoryRepository.findById(1L).get();
		
		category.setCategoryName("A");
		categoryRepository.save(category);
		
		Category savedCategory = categoryRepository.findById(1L).get();
		
		assertThat(savedCategory.getCategoryName()).isEqualTo("A");
	}
	
	@Test
	@Order(6)
	public void testCategoryDeletion() {
		
		categoryRepository.deleteById(1L);
		
		Optional<Category> deletedCategory = categoryRepository.findById(1L);
		
		assertThat(deletedCategory.isEmpty());
	}
}
