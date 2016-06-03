package org.examples.spring.dao.login.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.examples.spring.dao.BaseDao;
import org.examples.spring.dao.login.LoginDao;
import org.examples.spring.entity.user.SysUserInfo;
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
	public List<Map<String, Object>> login(SysUserInfo userInfo) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) COUNT_NUM FROM SYS_USER_INFO WHERE USER_NAME = ? AND PASS_WORD = ?");
		Object[] params = new Object[]{userInfo.getUserName(), userInfo.getPassWord()};
		List<Map<String, Object>> list = null;
		try {
			list = jdbcDaoImpl.queryListForSql(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(list.size());
		return list;
	}

	@Override
	public List<Map<String, Object>> checkUserInfo(SysUserInfo userInfo,
			String checkType) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) COUNT_NUM FROM SYS_USER_INFO WHERE 1=1 ");
		if("userName".equals(checkType))
			sql.append(" AND USER_NAME = ? ");
		if("emailAddress".equals(checkType))
			sql.append(" AND EMAIL_ADDRESS = ? ");
		Object[] params = new Object[]{userInfo.getUserName()};
		List<Map<String, Object>> list = null;
		try {
			list = jdbcDaoImpl.queryListForSql(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(list.size());
		return list;
	}

	


	
}
