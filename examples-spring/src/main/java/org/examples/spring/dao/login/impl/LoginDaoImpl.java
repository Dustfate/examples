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
	public SysUserInfo login(SysUserInfo userInfo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT USER_ID, USER_NAME, PASS_WORD, EMAIL_ADDRESS, PHONE_NUMBER, CARD_ID, REAL_NAME, 'STATUS', IP, SKIN, CREATE_DATE, UPDATE_DATE, LOGIN_DATE ");
		sql.append("FROM SYS_USER_INFO WHERE 1 = 1 ");
		sql.append("AND ((USER_NAME = ? AND PASS_WORD = ?) OR (EMAIL_ADDRESS = ? AND PASS_WORD = ?) OR (PHONE_NUMBER = ? AND PASS_WORD = ?)) ");
		sql.append(" ");
		Object[] params = new Object[]{userInfo.getUserName(), userInfo.getPassWord(), 
				userInfo.getEmailAddress(), userInfo.getPassWord(), 
				userInfo.getPhoneNumber(), userInfo.getPassWord()};
		List<SysUserInfo> list = null;
		try {
			list = jdbcDaoImpl.queryListForSql(sql.toString(), params, SysUserInfo.class);
			logger.info(list.size());
			if(list != null && list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> checkUserInfo(SysUserInfo userInfo,
			String checkType) throws Exception {
		StringBuffer sql = new StringBuffer();
		Object[] params = null;
		sql.append("SELECT COUNT(*) COUNT_NUM FROM SYS_USER_INFO WHERE 1=1 ");
		if("userName".equals(checkType)){
			sql.append(" AND USER_NAME = ? ");
			params = new Object[]{userInfo.getUserName()};
		}
		
		if("emailAddress".equals(checkType)){
			sql.append(" AND EMAIL_ADDRESS = ? ");
			params = new Object[]{userInfo.getEmailAddress()};
		}
		
		if("cardId".equals(checkType)){
			sql.append(" AND CARD_ID = ? ");
			params = new Object[]{userInfo.getCardId()};
		}
		
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
	public void updateLoginTime(SysUserInfo userInfo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE SYS_USER_INFO SET LOGIN_DATE=? WHERE USER_ID=?");
		Object[] params = new Object[]{userInfo.getLoginDate(), userInfo.getUserId()};
		jdbcDaoImpl.updateForSql(sql.toString(), params);
	}

	


	
}
