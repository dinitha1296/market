package com.dinitha.market.product.subdepartment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sub-departments")
public class SubDepartmentController {

	@Autowired
	private SubDepartmentService subDepartmentService;
	
	@GetMapping
	public List<SubDepartment> getSubDepartments() {
		return subDepartmentService.listAll();
	}
	
	@GetMapping("/{id}")
	public SubDepartment getSubDepartment(@PathVariable Long id) {
		return subDepartmentService.getSubDepartment(id);
	}
}
