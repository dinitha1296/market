package com.dinitha.market.product.subdepartment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubDepartmentService {

	@Autowired
	private SubDepartmentRepository subDepartmentRepository;
	
	public List<SubDepartment> listAll() {
		return subDepartmentRepository.findAll();
	}
	
	public SubDepartment getSubDepartment(long id) {
		return subDepartmentRepository.findById(id).get();
	}
}
