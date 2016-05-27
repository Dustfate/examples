package org.examples.spring.manager.login;

import org.examples.spring.entity.user.UserInfo;

public interface LoginService {
	
	public boolean login(String username, String password);
	
	public boolean login(UserInfo userInfo);
	
}
