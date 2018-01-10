package com.eduardobarrera.todoapp.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardobarrera.todoapp.entity.Task;

// TODO: Auto-generated Javadoc
/**
 * The Interface TaskRepository.
 */
@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Serializable>{
	
	/**
	 * Find by task id.
	 *
	 * @param taskId the task id
	 * @return the task
	 */
	public abstract Task findByTaskId(int taskId);
	
	/**
	 * Find by task name and creation date and status and category.
	 *
	 * @param taskName the task name
	 * @param creationDate the creation date
	 * @param status the status
	 * @param category the category
	 * @return the list
	 */
	public abstract List<Task> findByTaskNameAndCreationDateAndStatusAndCategory(String taskName, String creationDate, String status, String category);
}
