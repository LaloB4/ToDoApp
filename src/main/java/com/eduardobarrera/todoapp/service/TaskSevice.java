package com.eduardobarrera.todoapp.service;

import java.util.List;

import com.eduardobarrera.todoapp.model.TaskModel;

public interface TaskSevice {

	public abstract List<TaskModel> listAllTasks();
	public abstract TaskModel createOrEditTask(TaskModel taskModel);
	public abstract int deleteTaskById(int taskId);
	public abstract TaskModel findTaskModelById(int taskId);
	
}
