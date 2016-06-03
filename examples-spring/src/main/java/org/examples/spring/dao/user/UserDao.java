package org.examples.spring.dao.user;

import java.util.List;

import org.examples.spring.entity.user.SysUserInfo;
import org.examples.spring.entity.user.UserEntity;

public interface UserDao {

	public Long register(SysUserInfo userInfo);

	public abstract void createCollection();

	public abstract List<UserEntity> findList(int skip, int limit);

	public abstract List<UserEntity> findListByAge(int age);

	public abstract UserEntity findOne(String id);

	public abstract UserEntity findOneByUsername(String username);

	public abstract void insert(UserEntity entity);

	public abstract void update(UserEntity entity);

}
