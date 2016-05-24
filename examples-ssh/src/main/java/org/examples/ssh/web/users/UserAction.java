package org.examples.ssh.web.users;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.examples.ssh.entity.user.Users;
import org.examples.ssh.service.users.UsersServiceI;
import org.examples.ssh.util.Encrypt;
import org.examples.ssh.util.Json;
import org.examples.ssh.util.UUIDUtils;
import org.examples.ssh.web.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

@Namespace("/users")
@Action(value = "usersAction")
public class UserAction extends BaseAction implements ModelDriven<Users> {
	private static final Logger logger = Logger.getLogger(UserAction.class);

	private Users users = new Users();

	@Autowired
	private UsersServiceI usersService;

	@Override
	public Users getModel() {
		return users;
	}

	public void reg() {
		Json json = new Json();
		try {
			users.setPkid(UUIDUtils.getUUID32());
			users.setRealName("张三");
			users.setUserName("dustfate");
			users.setPassWords(Encrypt.md5("123456"));
			users.setCreateDate(new Date());
			usersService.save(users);
			json.setSuccess(true);
			json.setMsg("注册成功！");
			logger.info("注册成功！");
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}

		super.writeJson(json);

	}

	public void add() {
		Json j = new Json();
		try {
			users.setPkid(UUIDUtils.getUUID32());
			users.setRealName("张三");
			users.setUserName("dustfate");
			users.setPassWords(Encrypt.md5("123456"));
			Users u = usersService.save(users);
			j.setSuccess(true);
			j.setMsg("添加成功！");
			j.setObj(u);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}

		super.writeJson(j);

	}

	public void login() {
		Users u = usersService.login(users);
		Json j = new Json();
		if (u != null) {
			j.setSuccess(true);
			j.setMsg("登陆成功！");
		} else {
			j.setMsg("登录失败，用户名或密码错误！");
		}

		super.writeJson(j);
	}

	public void remove() {
		usersService.remove(users.getPkid());
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功！");
		super.writeJson(j);
	}

	public UsersServiceI getUserService() {
		return usersService;
	}

	public void setUserService(UsersServiceI usersService) {
		this.usersService = usersService;
	}
}
