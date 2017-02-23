package org.examples.spring.manager.login.impl;

import java.util.List;
import java.util.Map;

import org.examples.spring.dao.login.LoginDao;
import org.examples.spring.entity.user.SysUserInfo;
import org.examples.spring.manager.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Override
	public SysUserInfo login(SysUserInfo userInfo) {
		SysUserInfo user = null;
		try {
			return loginDao.login(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean checkUserName(SysUserInfo userInfo, String checkType) {
		List<Map<String, Object>> list = null;
		try {
			list = loginDao.checkUserInfo(userInfo, checkType);
			Integer count = 0;
			if (null != list && list.size() > 0) {
				count = Integer.parseInt(list.get(0).get("COUNT_NUM").toString());
			}
			return count <= 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void updateLoginTime(SysUserInfo userInfo) {
		try {
			loginDao.updateLoginTime(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
