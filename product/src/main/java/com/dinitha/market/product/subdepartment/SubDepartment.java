package com.dinitha.market.product.subdepartment;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dinitha.market.product.category.Category;
import com.dinitha.market.product.department.Department;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sub_department")
public class SubDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_department_id")
	private long subDepartmentId;
	
	@Column(name = "sub_department_name", nullable = false)
	private String subDepartmentName;
	
	@Column(name = "sub_department_code", unique = true, nullable = false)
	private String subDepartmentCode;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	@JsonManagedReference
	private Department department;
	
	@OneToMany(mappedBy = "subDepartment")
	@JsonBackReference
	private Set<Category> categories;
}
