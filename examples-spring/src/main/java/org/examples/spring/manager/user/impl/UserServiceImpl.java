package org.examples.spring.manager.user.impl;

import org.examples.spring.dao.user.UserDao;
import org.examples.spring.entity.user.SysUserInfo;
import org.examples.spring.manager.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean register(SysUserInfo userInfo) {
		return userDao.register(userInfo) > 0 ? true : false;
	}

}
