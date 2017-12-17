package com.eduardobarrera.todoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.eduardobarrera.todoapp.entity.Task;
import com.eduardobarrera.todoapp.repository.TaskRepository;
import com.eduardobarrera.todoapp.service.TaskSevice;

@Service("taskServiceImpl")
public class TaskSeviceImpl implements TaskSevice{
	
	@Autowired
	@Qualifier("taskRepository")
	private TaskRepository taskRepository;
	
	@Override
	public List<Task> listAllTasks() {		
		return taskRepository.findAll();
	}

}
