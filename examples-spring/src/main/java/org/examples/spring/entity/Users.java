package org.examples.spring.entity;

import org.examples.spring.util.page.Pageable;

public class Users extends Pageable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String usreId;
	private String userName;
	private String password;
	
	public String getUsreId() {
		return usreId;
	}
	public void setUsreId(String usreId) {
		this.usreId = usreId;
	}
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

}
