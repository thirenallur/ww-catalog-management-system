package com.thippeshhirenallur.catalogmanagementplatform.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.thippeshhirenallur.catalogmanagementplatform.model.Audit;

import java.io.Serializable;

@Entity
@Table(name = "MEDIA")
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class Media extends Audit implements Serializable {

	@Id
	@Column(name = "MEDIA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mediaId;

	@NotEmpty(message = "IMAGE_URL cannot be null or empty")
	@Column(name = "IMAGE_URL")
	private String imageUrl;

	@NotEmpty(message = "ALT_TEXT cannot be null or empty")
	@Column(name = "ALT_TEXT")
	private String altText;

	@NotNull(message = "PRODUCT_ID cannot be null or empty")
	@Column(name = "PRODUCT_ID")
	private Integer productId;
}
