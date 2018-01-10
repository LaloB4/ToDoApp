package com.eduardobarrera.todoapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Priority.
 */
@Entity
@Table(name = "priority")
public class Priority {

	/** The priority id. */
	@Id
	@GeneratedValue
	@Column(name = "priority_id", unique = true, nullable = false)
	private Integer priorityId;

	/** The priority description. */
	@Column(name = "priority_description")
	private String priorityDescription;

	/**
	 * Gets the priority id.
	 *
	 * @return the priority id
	 */
	public Integer getPriorityId() {
		return priorityId;
	}

	/**
	 * Sets the priority id.
	 *
	 * @param priorityId the new priority id
	 */
	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}

	/**
	 * Gets the priority description.
	 *
	 * @return the priority description
	 */
	public String getPriorityDescription() {
		return priorityDescription;
	}

	/**
	 * Sets the priority description.
	 *
	 * @param priorityDescription the new priority description
	 */
	public void setPriorityDescription(String priorityDescription) {
		this.priorityDescription = priorityDescription;
	}

	/**
	 * Instantiates a new priority.
	 *
	 * @param priorityId the priority id
	 * @param priorityDescription the priority description
	 */
	public Priority(Integer priorityId, String priorityDescription) {
		super();
		this.priorityId = priorityId;
		this.priorityDescription = priorityDescription;
	}

	/**
	 * Instantiates a new priority.
	 */
	public Priority() {
	}

}
