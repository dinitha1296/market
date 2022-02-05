package com.dinitha.market.product.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT * FROM product JOIN category USING(category_id) JOIN sub_department USING(sub_department_id) JOIN department USING(department_id) WHERE department_id = ?1", nativeQuery = true)
	List<Product> findByDepartmentId(Long departmentId);

	@Query(value = "SELECT * FROM product JOIN category USING(category_id) JOIN sub_department USING(sub_department_id) WHERE sub_department_id = ?1", nativeQuery = true)
	List<Product> findBySubDepartmentId(Long subDepartmentId);
	
	@Query(value = "SELECT * FROM product JOIN category USING(category_id) WHERE category_id = ?1", nativeQuery = true)
	List<Product> findByCategoryId(Long categoryId);
	
	List<Product> findByProductNameContainingIgnoreCase(String query);
	
	@Query(value = "SELECT * FROM product WHERE REGEXP_LIKE(LOWER(product_name), LOWER(?1))", nativeQuery = true)
	List<Product> findByRegexMatching(String query);
}
