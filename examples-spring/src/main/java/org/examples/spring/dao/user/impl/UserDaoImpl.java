package org.examples.spring.dao.user.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.examples.spring.dao.BaseDao;
import org.examples.spring.dao.user.UserDao;
import org.examples.spring.entity.user.SysUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.dal.spring.JdbcDaoImpl;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	private BaseDao baseDao;
	@Autowired
	private JdbcDaoImpl jdbcDaoImpl;

	@Override
	public Long register(SysUserInfo userInfo) {
		Long count = 0L;
		try {
			jdbcDaoImpl.save(userInfo);
			count = 1L;
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		}
		return count;
	}

	@Override
	public void createCollection() {
		
	}

	@Override
	public List<SysUserInfo> findList(int skip, int limit) {
		
		return null;
	}

	@Override
	public List<SysUserInfo> findListByAge(int age) {
		
		return null;
	}

	@Override
	public SysUserInfo findOne(String id) {
		
		return null;
	}

	@Override
	public SysUserInfo findOneByUsername(String username) {
		
		return null;
	}

	@Override
	public void insert(SysUserInfo entity) {
		
	}

	@Override
	public void update(SysUserInfo entity) {
		
	}

}
