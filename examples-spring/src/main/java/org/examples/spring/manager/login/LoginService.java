package org.examples.spring.manager.login;

import java.util.List;

import org.examples.spring.entity.user.SysUserInfo;

public interface LoginService {
	
	public List<SysUserInfo> login(SysUserInfo userInfo);

	public boolean checkUserName(SysUserInfo userInfo, String checkType);
	
}
