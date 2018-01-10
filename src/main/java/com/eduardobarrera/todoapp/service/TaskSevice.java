package com.eduardobarrera.todoapp.service;

import java.util.List;

import com.eduardobarrera.todoapp.model.TaskModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface TaskSevice.
 */
public interface TaskSevice {

	/**
	 * List all tasks.
	 *
	 * @return the list
	 */
	public abstract List<TaskModel> listAllTasks();
	
	/**
	 * Creates the or edit task.
	 *
	 * @param taskModel the task model
	 * @return the task model
	 */
	public abstract TaskModel createOrEditTask(TaskModel taskModel);
	
	/**
	 * Delete task by id.
	 *
	 * @param taskId the task id
	 * @return the int
	 */
	public abstract int deleteTaskById(int taskId);
	
	/**
	 * Find task model by id.
	 *
	 * @param taskId the task id
	 * @return the task model
	 */
	public abstract TaskModel findTaskModelById(int taskId);
	
	/**
	 * Search by user criteria.
	 *
	 * @param taskName the task name
	 * @param creationDate the creation date
	 * @param status the status
	 * @param category the category
	 * @return the list
	 */
	public abstract List<TaskModel> searchByUserCriteria(String taskName, String creationDate, String status, String category);
	
}
