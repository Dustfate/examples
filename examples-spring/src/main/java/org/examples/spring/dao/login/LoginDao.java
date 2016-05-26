package org.examples.spring.dao.login;

import org.examples.spring.entity.user.Users;

public interface LoginDao {
	
	public boolean login(String username, String password);
	
	public boolean login(Users user);
}
