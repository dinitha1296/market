package com.dinitha.market.product.department;

import java.util.Set;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dinitha.market.product.subdepartment.SubDepartment;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private long departmentId;
	
	@Column(name = "department_name", nullable = false)
	private String departmentName;
	
	@Column(name = "department_code", unique = true)
	private String departmentCode;
	
	@OneToMany(mappedBy = "department")
	@JsonBackReference
	private Set<SubDepartment> subDepartments;
}
