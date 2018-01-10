package com.eduardobarrera.todoapp.model;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskModel.
 */
public class TaskModel {

	/** The task id. */
	private int taskId;
	
	/** The task name. */
	private String taskName;
	
	/** The creation date. */
	private String creationDate;
	
	/** The due date. */
	private String dueDate;
	
	/** The task description. */
	private String taskDescription;
	
	/** The priority. */
	private String priority;
	
	/** The category. */
	private String category;
	
	/** The status. */
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
	 * Instantiates a new task model.
	 *
	 * @param taskId the task id
	 * @param taskName the task name
	 * @param creationDate the creation date
	 * @param dueDate the due date
	 * @param taskDescription the task description
	 * @param priority the priority
	 * @param category the category
	 * @param status the status
	 */
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

	/**
	 * Instantiates a new task model.
	 */
	public TaskModel() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TaskModel [taskId=" + taskId + ", taskName=" + taskName + ", creationDate=" + creationDate
				+ ", dueDate=" + dueDate + ", taskDescription=" + taskDescription + ", priority=" + priority
				+ ", category=" + category + ", status=" + status + "]";
	}

}
