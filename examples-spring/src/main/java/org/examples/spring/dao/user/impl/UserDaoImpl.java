package org.examples.spring.dao.user.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.examples.spring.dao.BaseDao;
import org.examples.spring.dao.user.UserDao;
import org.examples.spring.entity.user.UserEntity;
import org.examples.spring.entity.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	private BaseDao baseDao;

	@Override
	public boolean register(Users users) {
		return baseDao.insert(users) > 0 ? true : false;
	}

	@Override
	public void _test() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createCollection() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserEntity> findList(int skip, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findListByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(UserEntity entity) {
		// TODO Auto-generated method stub

	}

}
