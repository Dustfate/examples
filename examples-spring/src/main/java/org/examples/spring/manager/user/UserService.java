package org.examples.spring.manager.user;

import org.examples.spring.entity.user.UserInfo;

public interface UserService {
	
	/**
	 * 注册
	 * @param userInfo
	 * @return
	 */
	public boolean register(UserInfo userInfo);
	
}
