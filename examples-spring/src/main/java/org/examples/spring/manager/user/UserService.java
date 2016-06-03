package org.examples.spring.manager.user;

import org.examples.spring.entity.user.SysUserInfo;

public interface UserService {
	
	/**
	 * 注册
	 * @param userInfo
	 * @return
	 */
	public boolean register(SysUserInfo userInfo);
	
}
