package com.thippeshhirenallur.catalogmanagementplatform.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit implements Serializable {
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	@ApiModelProperty(hidden = true)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	@LastModifiedDate
	@ApiModelProperty(hidden = true)
	private Date updatedAt;
}
