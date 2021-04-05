package com.thippeshhirenallur.catalogmanagementplatform.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import com.thippeshhirenallur.catalogmanagementplatform.model.Audit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SKU")
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class SKU extends Audit implements Serializable {
	
	@Id
	@Column(name = "SKU_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private Integer skuId;
	
	@NotEmpty(message = "NAME cannot be null or empty")
	@Column(name = "NAME")
	private String name;
	
	@NotEmpty(message = "DESCRIPTION cannot be null or empty")
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "RETAIL_PRICE")
	private double retailPrice;
	
	@Column(name = "SALE_PRICE")
	private double salePrice;
	
	@NotEmpty(message = "INVENTORY_TYPE cannot be null or empty")
	@Column(name = "INVENTORY_TYPE")
	private String inventoryType;
	
	@Column(name = "QUANTITY_AVAILABLE")
	private double quantityAvailable;
	
	@NotNull(message = "PRODUCT_ID cannot be null or empty")
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	
}
