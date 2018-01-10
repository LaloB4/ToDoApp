package com.eduardobarrera.todoapp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardobarrera.todoapp.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {

	/**
	 * Find by username.
	 *
	 * @param userName the user name
	 * @return the user
	 */
	public abstract User findByUsername(String userName);
	
}
