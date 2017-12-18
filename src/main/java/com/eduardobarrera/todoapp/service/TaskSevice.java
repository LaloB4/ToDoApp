package com.eduardobarrera.todoapp.service;

import java.util.List;

import com.eduardobarrera.todoapp.model.TaskModel;

public interface TaskSevice {

	public abstract List<TaskModel> listAllTasks();
	
}
