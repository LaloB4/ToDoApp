package com.eduardobarrera.todoapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.eduardobarrera.todoapp.converter.TaskConverter;
import com.eduardobarrera.todoapp.entity.Task;
import com.eduardobarrera.todoapp.model.TaskModel;
import com.eduardobarrera.todoapp.repository.TaskRepository;
import com.eduardobarrera.todoapp.service.TaskSevice;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskSeviceImpl.
 */
@Service("taskServiceImpl")
public class TaskSeviceImpl implements TaskSevice{
	
	/** The logger. */
	private final Log LOGGER = LogFactory.getLog(TaskSeviceImpl.class);
	
	/** The task repository. */
	@Autowired
	@Qualifier("taskRepository")
	private TaskRepository taskRepository;
	
	/** The task converter. */
	@Autowired
	@Qualifier("taskConverter")
	private TaskConverter taskConverter;
	
	/* (non-Javadoc)
	 * @see com.eduardobarrera.todoapp.service.TaskSevice#listAllTasks()
	 */
	@Override
	public List<TaskModel> listAllTasks() {
		
		List<Task> taskEntityList = new ArrayList<Task>();
		taskEntityList = taskRepository.findAll();
		
		List<TaskModel> taskModelList = new ArrayList<TaskModel>();
		
		for(int i = 0; i < taskEntityList.size(); i++) {
			
			taskModelList.add(taskConverter.entityToModel(taskEntityList.get(i)));
		}
		
		LOGGER.info("METHOD: listAllTasks(); RETURNING OBJECT: " + taskModelList.toString());
		return taskModelList;
	}

	/* (non-Javadoc)
	 * @see com.eduardobarrera.todoapp.service.TaskSevice#createOrEditTask(com.eduardobarrera.todoapp.model.TaskModel)
	 */
	@Override
	public TaskModel createOrEditTask(TaskModel taskModel) {
		
		LOGGER.info("METHOD: createOrEditTask(TaskModel taskModel); PARAMS: " + taskModel.toString());
		Task taskEntity = taskRepository.save(taskConverter.modelToEntity(taskModel));
		TaskModel taskModelResult = taskConverter.entityToModel(taskEntity);
		LOGGER.info("METHOD: createOrEditTask(); RETURNING OBJECT: " + taskModelResult.toString());
		return taskModelResult;
		
	}

	/* (non-Javadoc)
	 * @see com.eduardobarrera.todoapp.service.TaskSevice#deleteTaskById(int)
	 */
	@Override
	public int deleteTaskById(int taskId) {
		
		LOGGER.info("METHOD: deleteTaskById(int taskId); PARAMS: taskId => " + taskId);
		int operationStatus = 1;
		
		try {
		
			taskRepository.delete(taskId);
			
		}catch(Exception e) {
			
			operationStatus = 0;
		}
		
		LOGGER.info("METHOD: deleteTaskById(int taskId); RETURNING OBJECT: " + operationStatus);
		return operationStatus;
		
	}

	/* (non-Javadoc)
	 * @see com.eduardobarrera.todoapp.service.TaskSevice#findTaskModelById(int)
	 */
	@Override
	public TaskModel findTaskModelById(int taskId) {
		
		LOGGER.info("METHOD: findTaskModelById(int taskId); PARAMS: taskId => " + taskId);
		Task taskEntity =  taskRepository.findByTaskId(taskId);
		TaskModel taskModel = taskConverter.entityToModel(taskEntity);
		LOGGER.info("METHOD: findTaskModelById(int taskId); RETURNING OBJECT: " + taskModel);
		return taskModel;
	}

	/* (non-Javadoc)
	 * @see com.eduardobarrera.todoapp.service.TaskSevice#searchByUserCriteria(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<TaskModel> searchByUserCriteria(String taskName, String creationDate, String status, String category) {
		
		LOGGER.info("METHOD: searchByUserCriteria(String taskName, String creationDate, String status, String category); PARAMS: taskName => " + taskName + ", creationDate => " + creationDate + ", status => " + status + ", category => " + category);
		
		List<Task> taskListEntity = new ArrayList<Task>();
		taskListEntity = taskRepository.findByTaskNameAndCreationDateAndStatusAndCategory(taskName, creationDate, status, category);
		
		List<TaskModel> taskListModel = new ArrayList<TaskModel>();
		
		for(int i = 0; i < taskListEntity.size(); i++) {
			taskListModel.add(taskConverter.entityToModel(taskListEntity.get(i)));
		}
	
		LOGGER.info("METHOD: searchByUserCriteria(String taskName, String creationDate, String status, String category); RETURNING OBJECT: " + taskListModel);	
		return taskListModel;
	}

}
