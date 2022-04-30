package com.dinitha.market.product.subdepartment;

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
public class SubDepartmentRepositoryTests {

//	@Autowired
//	private SubDepartmentRepository subDepartmentRepository;
//	
//	@Test
//	@Order(1)
//	public void testRepositoryAutowiring() {
//		assertThat(subDepartmentRepository).isNotNull();
//	}
	
//	@Test
//	@Order(2)
//	@Rollback(false)
//	public void testSubDepartmentCreation() {
//		
//		SubDepartment subDepartment = SubDepartment.builder()
//				.subDepartmentName("Sub-department")
//				.subDepartmentCode("DSD")
//				.build();
//		
//		subDepartmentRepository.save(subDepartment);
//		
//		assertThat(subDepartment.getSubDepartmentId()).isGreaterThan(0);
//	}
	
//	@Test
//	@Order(3)
//	public void testSubDepartmentFetch() {
//		
//		List<SubDepartment> subDepartmentList= subDepartmentRepository.findAll();
//		
//		assertThat(subDepartmentList).isNotNull();
//		assertThat(subDepartmentList.size()).isGreaterThan(0);
//	}
//	
//	@Test
//	@Order(4)
//	public void testSubDepartmentFetchById() {
//		
//		Optional<SubDepartment> subDepartment = subDepartmentRepository.findById(1L);
//		
//		assertThat(subDepartment).isNotNull();
//		assertThat(subDepartment.isPresent());
//		assertThat(subDepartment.get().getSubDepartmentId()).isEqualTo(1L);
//	}
//	
//	@Test
//	@Order(5)
//	@Rollback(false)
//	public void testSubDepartmentUpdate() {
//		
//		SubDepartment subepartment = subDepartmentRepository.findById(1L).get();
//		
//		subepartment.setSubDepartmentName("A");
//		subDepartmentRepository.save(subepartment);
//		
//		SubDepartment savedDepartment = subDepartmentRepository.findById(1L).get();
//		
//		assertThat(savedDepartment .getSubDepartmentName()).isEqualTo("A");
//	}
//	
//	@Test
//	@Order(6)
//	public void testSubDepartmentDeletion() {
//		
//		subDepartmentRepository.deleteById(1L);
//		
//		Optional<SubDepartment> deletedDepartment = subDepartmentRepository.findById(1L);
//		
//		assertThat(deletedDepartment.isEmpty());
//	}
}
