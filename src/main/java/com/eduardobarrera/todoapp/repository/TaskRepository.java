package com.eduardobarrera.todoapp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardobarrera.todoapp.entity.Task;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Serializable>{
	

}
