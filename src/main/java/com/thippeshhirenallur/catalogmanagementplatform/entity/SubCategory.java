package com.thippeshhirenallur.catalogmanagementplatform.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.thippeshhirenallur.catalogmanagementplatform.model.Audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModelProperty;
@Entity
@Table(name = "SUBCATEGORY")
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class SubCategory extends Audit implements Serializable {

	@Id
	@Column(name = "SUBCATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private Integer subCategoryId;

	@NotEmpty(message = "SUBCATEGORY_NAME cannot be null or empty")
	@Column(name = "SUBCATEGORY_NAME")
	private String subCategoryName;
	
	@NotNull(message = "CATEGORY_ID cannot be null or empty")
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUBCATEGORY_ID")
	private List<Product> products;
	
}
