package com.eduardobarrera.todoapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task" /*uniqueConstraints = @UniqueConstraint(
		columnNames = {"category_id","priority_id","status_id"})*/)
public class Task {

	@Id
	@GeneratedValue
	@Column(name = "task_id", unique = true, nullable = false)
	private int taskId;

	@Column(name = "task_name")
	private String taskName;

	@Column(name = "creation_date")
	private String creationDate;

	@Column(name = "due_date")
	private String dueDate;

	@Column(name = "task_description")
	private String taskDescription;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "categoryId")
	@Column(name = "category")
	private String category;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "priorityId")
	@Column(name = "priority")
	private String priority;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "statusId")
	@Column(name = "status")
	private String status;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

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

	public Task() {}	
}
