package com.eduardobarrera.todoapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "users")
public class User {

	/** The username. */
	@Id
	@Column(name = "username", nullable = false, unique = true, length = 45)
	private String username;
	
	/** The password. */
	@Column(name="password", nullable = false, length = 60)
	private String password;
	
	/** The enabled. */
	@Column(name="enabled", nullable = false)
	private boolean enabled;
	
	/** The user role. */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>();

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	public Set<UserRole> getUserRole() {
		return userRole;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRoles the new user role
	 */
	public void setUserRole(Set<UserRole> userRoles) {
		this.userRole = userRoles;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param enabled the enabled
	 */
	public User(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param enabled the enabled
	 * @param userRoles the user roles
	 */
	public User(String username, String password, boolean enabled, Set<UserRole> userRoles) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRoles;
	}

	/**
	 * Instantiates a new user.
	 */
	public User() {
	};
}
