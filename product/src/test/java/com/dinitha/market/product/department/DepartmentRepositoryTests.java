package com.dinitha.market.product.department;

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
public class DepartmentRepositoryTests {

//	@Autowired
//	private DepartmentRepository departmentRepository;
//	
//	@Test
//	@Order(1)
//	public void testRepositoryAutowiring() {
//		assertThat(departmentRepository).isNotNull();
//	}
	
//	@Test
//	@Order(2)
//	@Rollback(false)
//	public void testDepartmentCreation() {
//		
//		Department department = Department.builder()
//				.departmentName("Department")
//				.departmentCode("D")
//				.build();
//		
//		departmentRepository.save(department);
//		
//		assertThat(department.getDepartmentId()).isGreaterThan(0);
//	}
	
//	@Test
//	@Order(3)
//	public void testDepartmentFetch() {
//		
//		List<Department> departmentList= departmentRepository.findAll();
//		
//		assertThat(departmentList).isNotNull();
//		assertThat(departmentList.size()).isGreaterThan(0);
//	}
//	
//	@Test
//	@Order(4)
//	public void testDepartmentFetchById() {
//		
//		Optional<Department> department = departmentRepository.findById(1L);
//		
//		assertThat(department).isNotNull();
//		assertThat(department.isPresent());
//		assertThat(department.get().getDepartmentId()).isEqualTo(1L);
//	}
//	
//	@Test
//	@Order(5)
//	@Rollback(false)
//	public void testDepartmentUpdate() {
//		
//		Department department = departmentRepository.findById(1L).get();
//		
//		department.setDepartmentName("A");
//		departmentRepository.save(department);
//		
//		Department savedDepartment = departmentRepository.findById(1L).get();
//		
//		assertThat(savedDepartment .getDepartmentName()).isEqualTo("A");
//	}
//	
//	@Test
//	@Order(6)
//	public void testDepartmentDeletion() {
//		
//		departmentRepository.deleteById(1L);
//		
//		Optional<Department> deletedDepartment = departmentRepository.findById(1L);
//		
//		assertThat(deletedDepartment.isEmpty());
//	}
}
