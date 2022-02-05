package com.dinitha.market.product.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> listAll() {
		return departmentRepository.findAll();
	}
	
	public Department getDepartment(Long id) {
		return departmentRepository.findById(id).get();
	}
	
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}
}
