package org.examples.spring.dao.login;

import java.util.List;
import java.util.Map;

import org.examples.spring.entity.user.SysUserInfo;

public interface LoginDao {

	public SysUserInfo login(SysUserInfo userInfo) throws Exception;
	
	public List<Map<String, Object>> checkUserInfo(SysUserInfo userInfo, String checkType) throws Exception;
	
	public void updateLoginTime(SysUserInfo userInfo) throws Exception;
}
