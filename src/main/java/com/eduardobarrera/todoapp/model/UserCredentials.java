package com.eduardobarrera.todoapp.model;

// TODO: Auto-generated Javadoc
/**
 * The Class UserCredentials.
 */
public class UserCredentials {

	/** The user name. */
	public String userName;
	
	/** The password. */
	public String password;

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * Instantiates a new user credentials.
	 *
	 * @param userName the user name
	 * @param password the password
	 */
	public UserCredentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * Instantiates a new user credentials.
	 */
	public UserCredentials() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCredentials [userName=" + userName + ", password=" + password + "]";
	};
}
