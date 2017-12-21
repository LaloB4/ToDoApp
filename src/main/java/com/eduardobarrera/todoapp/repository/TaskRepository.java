package com.eduardobarrera.todoapp.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardobarrera.todoapp.entity.Task;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Serializable>{
	
	public abstract Task findByTaskId(int taskId);
	public abstract List<Task> findByTaskNameAndCreationDateAndStatusAndCategory(String taskName, String creationDate, String status, String category);
}
