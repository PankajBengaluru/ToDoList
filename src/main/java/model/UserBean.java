package model;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	private String firstName;
	private String lastName;
	private String username;
	private transient String password;
	
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstname() {
		return this.firstName;
	}
	
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastname() {
		return this.lastName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
}
