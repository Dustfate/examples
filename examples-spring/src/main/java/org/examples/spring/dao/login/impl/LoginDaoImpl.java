package org.examples.spring.dao.login.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.examples.spring.dao.BaseDao;
import org.examples.spring.dao.login.LoginDao;
import org.examples.spring.entity.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.dal.spring.JdbcDaoImpl;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	@Autowired
	private BaseDao baseDao;
	@Autowired
	private JdbcDaoImpl jdbcDaoImpl;

	@Override
	public boolean login(String username, String password) {
		List<Map<String, Object>> list = baseDao
				.search("SELECT ID, CREATEDATE, EMAILADDRESS, PASSWORD, PHONENUMBER, REALNAME, UPDATEDATE, USERNAME FROM USERS");
		logger.info(list.size() + "");
		return list.size() > 0 ? true : false;
	}

	public boolean login(Users user) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) COUNT_NUM FROM USERS WHERE USERNAME = ? AND PASSWORD = ?");
		Object[] params = new Object[]{user.getUsername(), user.getPassword()};
		List<Map<String, Object>> list = null;
		try {
			list = jdbcDaoImpl.queryListForSql(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(list.size());
		return false;//jdbcDaoImpl.queryCount(user) > 0 ? true : false;
	}

}
