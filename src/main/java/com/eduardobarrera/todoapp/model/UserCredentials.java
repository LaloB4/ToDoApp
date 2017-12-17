package com.eduardobarrera.todoapp.model;

public class UserCredentials {

	public String userName;
	public String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserCredentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public UserCredentials() {
	}

	@Override
	public String toString() {
		return "UserCredentials [userName=" + userName + ", password=" + password + "]";
	};
}
