package com.eduardobarrera.todoapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue
	@Column(name = "status_id", unique = true, nullable = false)
	private Integer statusId;

	@Column(name = "status_description")
	private String statusDescription;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Status(Integer statusId, String statusDescription) {
		super();
		this.statusId = statusId;
		this.statusDescription = statusDescription;
	}

	public Status() {
	}

}
