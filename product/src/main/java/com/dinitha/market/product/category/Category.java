package com.dinitha.market.product.category;

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

import com.dinitha.market.product.product.Product;
import com.dinitha.market.product.subdepartment.SubDepartment;
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
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private long categoryId;
	
	@Column(name = "category_name", nullable = false)
	private String categoryName;
	
	@Column(name = "category_code", unique = true, nullable = false)
	private String categoryCode;
	
	@ManyToOne
	@JoinColumn(name = "sub_department_id")
	@JsonManagedReference
	private SubDepartment subDepartment;
	
	@OneToMany(mappedBy = "category")
	@JsonBackReference
	private Set<Product> products;
}
