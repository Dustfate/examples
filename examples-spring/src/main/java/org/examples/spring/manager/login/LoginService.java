package org.examples.spring.manager.login;

import org.examples.spring.entity.user.SysUserInfo;

public interface LoginService {
	
	public SysUserInfo login(SysUserInfo userInfo);

	public void updateLoginTime(SysUserInfo userInfo);
	
	public boolean checkUserName(SysUserInfo userInfo, String checkType);
	
}
