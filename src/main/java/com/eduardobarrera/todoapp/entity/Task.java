package com.eduardobarrera.todoapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Task.
 */
@Entity
@Table(name = "task" /*uniqueConstraints = @UniqueConstraint(
		columnNames = {"category_id","priority_id","status_id"})*/)
public class Task {

	/** The task id. */
	@Id
	@GeneratedValue
	@Column(name = "task_id", unique = true, nullable = false)
	private int taskId;

	/** The task name. */
	@Column(name = "task_name")
	private String taskName;

	/** The creation date. */
	@Column(name = "creation_date")
	private String creationDate;

	/** The due date. */
	@Column(name = "due_date")
	private String dueDate;

	/** The task description. */
	@Column(name = "task_description")
	private String taskDescription;

	//@ManyToOne(fetch = FetchType.LAZY)
	/** The category. */
	//@JoinColumn(name = "categoryId")
	@Column(name = "category")
	private String category;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	/** The priority. */
	//@JoinColumn(name = "priorityId")
	@Column(name = "priority")
	private String priority;

	//@ManyToOne(fetch = FetchType.LAZY)
	/** The status. */
	//@JoinColumn(name = "statusId")
	@Column(name = "status")
	private String status;

	/**
	 * Gets the task id.
	 *
	 * @return the task id
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * Sets the task id.
	 *
	 * @param taskId the new task id
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * Gets the task name.
	 *
	 * @return the task name
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the task name.
	 *
	 * @param taskName the new task name
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the due date.
	 *
	 * @return the due date
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * Sets the due date.
	 *
	 * @param dueDate the new due date
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Gets the task description.
	 *
	 * @return the task description
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * Sets the task description.
	 *
	 * @param taskDescription the new task description
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 *
	 * @param priority the new priority
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Instantiates a new task.
	 *
	 * @param taskId the task id
	 * @param taskName the task name
	 * @param creationDate the creation date
	 * @param dueDate the due date
	 * @param taskDescription the task description
	 * @param priority the priority
	 * @param status the status
	 * @param category the category
	 */
	public Task(int taskId, String taskName, String creationDate, String dueDate, String taskDescription,
			String priority, String status, String category) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.creationDate = creationDate;
		this.dueDate = dueDate;
		this.taskDescription = taskDescription;
		this.priority = priority;
		this.status = status;
		this.category = category;
	}

	/**
	 * Instantiates a new task.
	 */
	public Task() {}	
}
