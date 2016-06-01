package org.examples.spring.dao.login;

import java.util.List;
import java.util.Map;

import org.examples.spring.entity.user.UserInfo;

public interface LoginDao {

	public List<Map<String, Object>> login(UserInfo userInfo);
	
	public List<Map<String, Object>> checkUserInfo(UserInfo userInfo, String checkType);
	
}
