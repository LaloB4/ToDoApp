package com.eduardobarrera.todoapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "priority")
public class Priority {

	@Id
	@GeneratedValue
	@Column(name = "priority_id", unique = true, nullable = false)
	private Integer priorityId;

	@Column(name = "priority_description")
	private String priorityDescription;

	public Integer getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityDescription() {
		return priorityDescription;
	}

	public void setPriorityDescription(String priorityDescription) {
		this.priorityDescription = priorityDescription;
	}

	public Priority(Integer priorityId, String priorityDescription) {
		super();
		this.priorityId = priorityId;
		this.priorityDescription = priorityDescription;
	}

	public Priority() {
	}

}
