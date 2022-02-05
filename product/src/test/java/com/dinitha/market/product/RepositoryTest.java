package com.dinitha.market.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.dinitha.market.product.category.Category;
import com.dinitha.market.product.category.CategoryRepository;
import com.dinitha.market.product.department.Department;
import com.dinitha.market.product.department.DepartmentRepository;
import com.dinitha.market.product.product.Product;
import com.dinitha.market.product.product.ProductRepository;
import com.dinitha.market.product.subdepartment.SubDepartment;
import com.dinitha.market.product.subdepartment.SubDepartmentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositoryTest {

	@Autowired private ProductRepository productRepository;
	@Autowired private CategoryRepository categoryRepository;
	@Autowired private SubDepartmentRepository subDepartmentRepository;
	@Autowired private DepartmentRepository departmentRepository;
	
	@Test
	@Order(1)
	public void testRepositoryAutoWiring() {
		assertThat(productRepository).isNotNull();
		assertThat(categoryRepository).isNotNull();
		assertThat(subDepartmentRepository).isNotNull();
		assertThat(departmentRepository).isNotNull();
	}
	
	@Test
	@Order(2)
	@Rollback(false)
	public void testEntityCreation() {
		
		Department department = Department.builder()
				.departmentName("Department")
				.departmentCode("D")
				.build();
		
		departmentRepository.save(department);
		
		SubDepartment subDepartment = SubDepartment.builder()
				.subDepartmentName("Sub department")
				.subDepartmentCode("DSD")
				.department(department)
				.build();
		
		subDepartmentRepository.save(subDepartment);
		
		Category category = Category.builder()
				.categoryName("Category")
				.categoryCode("DSDCT")
				.subDepartment(subDepartment)
				.build();
		
		categoryRepository.save(category);
		
		Product product = Product.builder()
				.productName("Product")
				.productDescription("Product descripton")
				.productUnitPrice(200d)
				.productMinQuantity(1)
				.productMaxQuantity(20)
				.productQuantityIncrement(1)
				.category(category)
				.build();
		
		productRepository.save(product);
		
		assertThat(department.getDepartmentId()).isGreaterThan(0);
		assertThat(subDepartment.getSubDepartmentId()).isGreaterThan(0);
		assertThat(category.getCategoryId()).isGreaterThan(0);
		assertThat(product.getProductId()).isGreaterThan(0);
	}
}
