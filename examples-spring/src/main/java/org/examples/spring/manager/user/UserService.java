package org.examples.spring.manager.user;

import org.examples.spring.entity.user.Users;

public interface UserService {
	
	/**
	 * 注册
	 * @param users
	 * @return
	 */
	public boolean register(Users users);
	
}
