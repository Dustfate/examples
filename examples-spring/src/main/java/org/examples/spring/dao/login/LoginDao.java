package org.examples.spring.dao.login;

import org.examples.spring.entity.user.UserInfo;

public interface LoginDao {

	public boolean login(String username, String password);

	public boolean login(UserInfo userInfo);
}
