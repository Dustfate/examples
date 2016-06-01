package org.examples.spring.manager.login;

import org.examples.spring.entity.user.UserInfo;

public interface LoginService {
	
	public boolean login(UserInfo userInfo);

	public boolean checkUserName(UserInfo userInfo, String checkType);
	
}
