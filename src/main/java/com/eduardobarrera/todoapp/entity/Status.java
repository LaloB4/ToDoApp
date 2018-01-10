package com.eduardobarrera.todoapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Status.
 */
@Entity
@Table(name = "status")
public class Status {

	/** The status id. */
	@Id
	@GeneratedValue
	@Column(name = "status_id", unique = true, nullable = false)
	private Integer statusId;

	/** The status description. */
	@Column(name = "status_description")
	private String statusDescription;

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the status description.
	 *
	 * @return the status description
	 */
	public String getStatusDescription() {
		return statusDescription;
	}

	/**
	 * Sets the status description.
	 *
	 * @param statusDescription the new status description
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	/**
	 * Instantiates a new status.
	 *
	 * @param statusId the status id
	 * @param statusDescription the status description
	 */
	public Status(Integer statusId, String statusDescription) {
		super();
		this.statusId = statusId;
		this.statusDescription = statusDescription;
	}

	/**
	 * Instantiates a new status.
	 */
	public Status() {
	}

}
