package com.dinitha.market.product.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Page<Product> findAll(Pageable pageable);

	@Query(
		value = "SELECT * FROM product JOIN category USING(category_id) JOIN sub_department USING(sub_department_id) JOIN department USING(department_id) WHERE department_id = ?1",
		countQuery = "SELECT COUNT(*) FROM product JOIN category USING(category_id) JOIN sub_department USING(sub_department_id) JOIN department USING(department_id) WHERE department_id = ?1",
		nativeQuery = true)
	Page<Product> findByDepartmentId(Long departmentId, Pageable pageable);

	@Query(
		value = "SELECT * FROM product JOIN category USING(category_id) JOIN sub_department USING(sub_department_id) WHERE sub_department_id = ?1",
		countQuery = "SELECT COUNT(*) FROM product JOIN category USING(category_id) JOIN sub_department USING(sub_department_id) WHERE sub_department_id = ?1",
		nativeQuery = true)
	Page<Product> findBySubDepartmentId(Long subDepartmentId, Pageable pageable);
	
	@Query(
		value = "SELECT * FROM product JOIN category USING(category_id) WHERE category_id = ?1",
		countQuery = "SELECT COUNT(*) FROM product JOIN category USING(category_id) WHERE category_id = ?1",
		nativeQuery = true)
	Page<Product> findByCategoryId(Long categoryId, Pageable pageable);
	
	Page<Product> findByProductNameContainingIgnoreCase(String query, Pageable pageable);
	
	@Query(
		value = "SELECT * FROM product WHERE REGEXP_LIKE(LOWER(product_name), LOWER(?1))",
		countQuery = "SELECT COUNT(*) FROM product WHERE REGEXP_LIKE(LOWER(product_name), LOWER(?1))",
		nativeQuery = true)
	Page<Product> findByRegexMatching(String query, Pageable pageable);
}
