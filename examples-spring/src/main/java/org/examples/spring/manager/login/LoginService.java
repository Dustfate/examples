package org.examples.spring.manager.login;

import org.examples.spring.entity.user.SysUserInfo;

public interface LoginService {
	
	public boolean login(SysUserInfo userInfo);

	public boolean checkUserName(SysUserInfo userInfo, String checkType);
	
}
