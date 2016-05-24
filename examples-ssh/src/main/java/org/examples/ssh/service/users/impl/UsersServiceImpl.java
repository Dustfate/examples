package org.examples.ssh.service.users.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.examples.ssh.dao.BaseDaoI;
import org.examples.ssh.entity.user.Users;
import org.examples.ssh.service.users.UsersServiceI;
import org.examples.ssh.util.Encrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersServiceImpl implements UsersServiceI {

	private static final Logger logger = Logger.getLogger(UsersServiceImpl.class);

	@Autowired
	private BaseDaoI<Users> userDao;

	@Override
	public Users save(Users user) {
		Users t = new Users();
		BeanUtils.copyProperties(user, t, new String[] { "pwd" });
		t.setPkid(UUID.randomUUID().toString());
		t.setCreateDate(new Date());
		t.setPassWords(Encrypt.e(user.getPassWords()));
		userDao.save(t);
		BeanUtils.copyProperties(t, user);
		return user;
	}

	@Override
	public Users login(Users user) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pwd", Encrypt.e(user.getPassWords()));
		params.put("name", user.getUserName());
		Users t = userDao.get("from Tuser t where t.name = :name and t.pwd = :pwd", params);
		if (t != null) {
			return user;
		}
		return null;
	}

	@Override
	public void remove(String ids) {
		// for (String id : ids.split(",")) {
		// Tuser u = userDao.get(Tuser.class, id);
		// if (u != null) {
		// userDao.delete(u);
		// }
		// }
		String[] nids = ids.split(",");
		String hql = "delete Tuser t where t.id in (";
		for (int i = 0; i < nids.length; i++) {
			if (i > 0) {
				hql += ",";
			}
			hql += "'" + nids[i] + "'";
		}
		hql += ")";
		userDao.executeHql(hql);
	}

	@Override
	public void updateUsers(Users user) {
		// TODO Auto-generated method stub
		
	}
	

	public BaseDaoI<Users> getUserDao() {
		return userDao;
	}

	public void setUserDao(BaseDaoI<Users> userDao) {
		this.userDao = userDao;
	}
}
