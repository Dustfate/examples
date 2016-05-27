package org.examples.spring.manager.login.impl;

import java.util.List;
import java.util.Map;

import org.examples.spring.dao.login.LoginDao;
import org.examples.spring.entity.user.UserInfo;
import org.examples.spring.manager.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean login(UserInfo userInfo) {
		List<Map<String, Object>> list = loginDao.login(userInfo);

		Integer count = 0;
		if (null != list && list.size() > 0) {
			count = Integer.parseInt(list.get(0).get("COUNT_NUM").toString());
		}
		return count > 0 ? true : false;
	}

	@Override
	public boolean checkUserName(UserInfo userInfo) {
		List<Map<String, Object>> list = loginDao.checkUserName(userInfo);
		Integer count = 0;
		if (null != list && list.size() > 0) {
			count = Integer.parseInt(list.get(0).get("COUNT_NUM").toString());
		}
		return count > 0 ? true : false;
	}

}
