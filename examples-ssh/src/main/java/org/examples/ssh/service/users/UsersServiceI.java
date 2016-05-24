package org.examples.ssh.service.users;

import org.examples.ssh.entity.user.Users;

/**
 * 用户信息操作类
 * @Title: UsersServiceI.java
 * @Package org.examples.ssh.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年4月26日 下午5:19:40
 */
public interface UsersServiceI {

	public Users login(Users user);
	
	public Users save(Users user);

	public void updateUsers(Users user);
	
	public void remove(String id);

}
