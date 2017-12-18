package com.eduardobarrera.todoapp.model;

public class TaskModel {

	private int taskId;
	private String taskName;
	private String creationDate;
	private String dueDate;
	private String taskDescription;
	private String priority;
	private String category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TaskModel(int taskId, String taskName, String creationDate, String dueDate, String taskDescription,
			String priority, String category, String status) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.creationDate = creationDate;
		this.dueDate = dueDate;
		this.taskDescription = taskDescription;
		this.priority = priority;
		this.category = category;
		this.status = status;
	}

	public TaskModel() {
		super();
	}

	@Override
	public String toString() {
		return "TaskModel [taskId=" + taskId + ", taskName=" + taskName + ", creationDate=" + creationDate
				+ ", dueDate=" + dueDate + ", taskDescription=" + taskDescription + ", priority=" + priority
				+ ", category=" + category + ", status=" + status + "]";
	}

}
