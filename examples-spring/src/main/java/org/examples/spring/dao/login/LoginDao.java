package org.examples.spring.dao.login;

import java.util.List;
import java.util.Map;

import org.examples.spring.entity.user.SysUserInfo;

public interface LoginDao {

	public List<Map<String, Object>> login(SysUserInfo userInfo);
	
	public List<Map<String, Object>> checkUserInfo(SysUserInfo userInfo, String checkType);
	
}
