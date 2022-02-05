package com.dinitha.market.product.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dinitha.market.product.category.Category;
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
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "product_description")
	private String productDescription;
	
	@Column(name = "product_unit_price", nullable = false)
	private double productUnitPrice;
	
	@Column(name = "product_is_available")
	private boolean productIsAvailable;
	
	@Column(name = "product_image_url")
	private String productImageURL;
	
	@Column(name = "product_min_quantity", nullable = false)
	private int productMinQuantity;
	
	@Column(name = "product_max_quantity", nullable = false)
	private int productMaxQuantity;
	
	@Column(name = "product_quantity_increment", nullable = false)
	private int productQuantityIncrement;
	
	@Column(name = "product_popularity_score", nullable = false)
	private float productPopularityScore;
	
	@Column(name = "product_unit")
	private String productUnit;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonManagedReference
	private Category category;
}
