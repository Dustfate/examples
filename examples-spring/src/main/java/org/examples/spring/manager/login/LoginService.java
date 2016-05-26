package org.examples.spring.manager.login;

import org.examples.spring.entity.user.Users;

public interface LoginService {
	
	public boolean login(String username, String password);
	
	public boolean login(Users user);
	
}
