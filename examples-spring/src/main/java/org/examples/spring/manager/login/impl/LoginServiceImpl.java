package org.examples.spring.manager.login.impl;

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
	public boolean login(String username, String password) {
		return loginDao.login(username, password);
	}

	@Override
	public boolean login(UserInfo userInfo) {
		return loginDao.login(userInfo);
	}
	

}
