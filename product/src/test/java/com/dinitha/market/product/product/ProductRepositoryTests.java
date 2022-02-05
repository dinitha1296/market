package com.dinitha.market.product.product;

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
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Test 
	@Order(1)
	public void testRepositoryAutowiring() {
		assertThat(productRepository).isNotNull();
	}
	
	@Test
	@Rollback(false)
	@Order(2)
	public void testProductCreation() {
		
		Product product = Product.builder()
				.productName("Abcd")
				.productDescription("aaaa")
				.productUnitPrice(200D)
				.productMinQuantity(1)
				.productMaxQuantity(10)
				.productQuantityIncrement(1)
				.productPopularityScore(0.5F)
				.category(null)
				.build();
		
		productRepository.save(product);
		assertThat(product.getProductId()).isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testProductListFetch() {
		
		List<Product> productList =  productRepository.findAll();
		
		assertThat(productList).isNotNull();
		assertThat(productList.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	public void testProductFetchById() {
		
		Optional<Product> product = productRepository.findById(1L);
		
		assertThat(product).isNotNull();
		assertThat(product.isPresent());
		assertThat(product.get().getProductId()).isEqualTo(1L);
	}
	
	@Test
	@Order(5)
	@Rollback(false)
	public void testProductUpdate() {
		
		Product product = productRepository.findById(1L).get();
		
		product.setProductName("A");
		productRepository.save(product);
		
		Product savedProduct = productRepository.findById(1L).get();
		
		assertThat(savedProduct.getProductName()).isEqualTo("A");
	}
	
	@Test
	@Order(6)
	public void testProductDeletion() {
		
		productRepository.deleteById(1L);
		
		Optional<Product> deletedProduct = productRepository.findById(1L);
		
		assertThat(deletedProduct.isEmpty());
	}
}
