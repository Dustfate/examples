package org.examples.spring.dao.user;

import java.util.List;

import org.examples.spring.entity.user.SysUserInfo;

public interface UserDao {

	public Long register(SysUserInfo userInfo);

	public abstract void createCollection();

	public abstract List<SysUserInfo> findList(int skip, int limit);

	public abstract List<SysUserInfo> findListByAge(int age);

	public abstract SysUserInfo findOne(String id);

	public abstract SysUserInfo findOneByUsername(String username);

	public abstract void insert(SysUserInfo entity);

	public abstract void update(SysUserInfo entity);

}
