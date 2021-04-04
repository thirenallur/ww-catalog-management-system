package com.thippeshhirenallur.catalogmanagementplatform.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.thippeshhirenallur.catalogmanagementplatform.model.Audit;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class Product extends Audit implements Serializable {

	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@NotEmpty(message = "PRODUCT_NAME cannot be null or empty")
	@Column(name = "PRODUCT_NAME")
	private String productName;

	@NotEmpty(message = "DESCRIPTION cannot be null or empty")
	@Column(name = "DESCRIPTION")
	private String description;

	@NotEmpty(message = "URL cannot be null or empty")
	@Column(name = "URL")
	private String url;

	@NotEmpty(message = "CURRENCY cannot be null or empty")
	@Column(name = "CURRENCY")
	private String currency;
	
	@NotNull(message = "CATEGORY_ID cannot be null or empty")
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	
	@NotNull(message = "SUBCATEGORY_ID cannot be null or empty")
	@Column(name = "SUBCATEGORY_ID")
	private Integer subcategoryId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Media> medias;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List <SKU> skus;

}
