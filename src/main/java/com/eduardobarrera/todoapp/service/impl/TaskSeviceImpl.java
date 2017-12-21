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

	@Override
	public TaskModel createOrEditTask(TaskModel taskModel) {
		
		Task taskEntity = taskRepository.save(taskConverter.modelToEntity(taskModel));
		return taskConverter.entityToModel(taskEntity);
		
	}

	@Override
	public int deleteTaskById(int taskId) {
		
		taskRepository.delete(taskId);
		return 0;
		
	}

	@Override
	public TaskModel findTaskModelById(int taskId) {
		
		Task taskEntity =  taskRepository.findByTaskId(taskId);
		return taskConverter.entityToModel(taskEntity);
	}

	@Override
	public List<TaskModel> searchByUserCriteria(String taskName, String creationDate, String status, String category) {
		
		List<Task> taskListEntity = new ArrayList<Task>();
		taskListEntity = taskRepository.findByTaskNameAndCreationDateAndStatusAndCategory(taskName, creationDate, status, category);
		
		List<TaskModel> taskListModel = new ArrayList<TaskModel>();
		
		for(int i = 0; i < taskListEntity.size(); i++) {
			taskListModel.add(taskConverter.entityToModel(taskListEntity.get(i)));
		}
	
		return taskListModel;
	}

}
