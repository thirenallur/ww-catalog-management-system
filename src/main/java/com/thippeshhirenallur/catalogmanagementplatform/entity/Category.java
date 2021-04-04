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
@Table(name = "CATEGORY")
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class Category extends Audit implements Serializable {

	@Id
	@Column(name = "CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;

	@NotEmpty(message = "CATEGORY_NAME cannot be null or empty")
	@NotNull
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORY_ID")
	private List<SubCategory> subCategories;
}
