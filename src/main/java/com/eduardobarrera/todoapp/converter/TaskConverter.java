package com.eduardobarrera.todoapp.converter;

import org.springframework.stereotype.Component;

import com.eduardobarrera.todoapp.entity.Task;
import com.eduardobarrera.todoapp.model.TaskModel;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskConverter.
 */
@Component("taskConverter")
public class TaskConverter {
	
	/**
	 * Entity to model.
	 *
	 * @param taskEntity the task entity
	 * @return the task model
	 */
	//Entity to Model
	public TaskModel entityToModel(Task taskEntity) {
		
		TaskModel taskModel = new TaskModel();
		
		taskModel.setTaskId(taskEntity.getTaskId());
		taskModel.setTaskName(taskEntity.getTaskName());
		taskModel.setTaskDescription(taskEntity.getTaskDescription());
		taskModel.setCreationDate(taskEntity.getCreationDate());
		taskModel.setDueDate(taskEntity.getDueDate());
		taskModel.setPriority(taskEntity.getPriority());
		taskModel.setStatus(taskEntity.getStatus());
		taskModel.setCategory(taskEntity.getCategory());

		return taskModel;
		
	}
	
	/**
	 * Model to entity.
	 *
	 * @param taskModel the task model
	 * @return the task
	 */
	//Model to Entity
	public Task modelToEntity(TaskModel taskModel) {
		
		Task taskEntity = new Task();
		
		taskEntity.setTaskId(taskModel.getTaskId());
		taskEntity.setTaskName(taskModel.getTaskName());
		taskEntity.setTaskDescription(taskModel.getTaskDescription());
		taskEntity.setCreationDate(taskModel.getCreationDate());
		taskEntity.setDueDate(taskModel.getDueDate());
		taskEntity.setPriority(taskModel.getPriority());
		taskEntity.setStatus(taskModel.getStatus());
		taskEntity.setCategory(taskModel.getCategory());
		
		return taskEntity;
		
	}

}
