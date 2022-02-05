package com.dinitha.market.product.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping
	public List<Department> getDepartments() {
		return departmentService.listAll();
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable Long id) {
		return departmentService.getDepartment(id);
	}
}
