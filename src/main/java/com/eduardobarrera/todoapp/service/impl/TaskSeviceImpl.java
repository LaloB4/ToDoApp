package com.eduardobarrera.todoapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.eduardobarrera.todoapp.converter.TaskConverter;
import com.eduardobarrera.todoapp.entity.Task;
import com.eduardobarrera.todoapp.model.TaskModel;
import com.eduardobarrera.todoapp.repository.TaskRepository;
import com.eduardobarrera.todoapp.service.TaskSevice;

@Service("taskServiceImpl")
public class TaskSeviceImpl implements TaskSevice{
	
	@Autowired
	@Qualifier("taskRepository")
	private TaskRepository taskRepository;
	
	@Autowired
	@Qualifier("taskConverter")
	private TaskConverter taskConverter;
	
	@Override
	public List<TaskModel> listAllTasks() {
		
		List<Task> taskEntityList = new ArrayList<Task>();
		taskEntityList = taskRepository.findAll();
		
		List<TaskModel> taskModelList = new ArrayList<TaskModel>();
		
		for(int i = 0; i < taskEntityList.size(); i++) {
			
			taskModelList.add(taskConverter.entityToModel(taskEntityList.get(i)));
		}
		
		return taskModelList;
	}

}
