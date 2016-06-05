package org.examples.spring.web.login;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.examples.spring.entity.user.SysUserInfo;
import org.examples.spring.manager.login.LoginService;
import org.examples.spring.manager.user.UserService;
import org.examples.spring.util.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dexcoder.commons.utils.UUIDUtils;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	private static final Logger logger = Logger
			.getLogger(LoginController.class);
	private SysUserInfo userInfo;

	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;

	public void writeJson(Object object) {
		try {

			String json = JSON.toJSONStringWithDateFormat(object,
					"yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/hello")
	public String hello() {
		try {
			// loginService.search();
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		return "hello";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public JSON register(SysUserInfo userInfo) {
		userInfo.setUserId(UUIDUtils.getUUID32());
		userInfo.setCreateDate(new Date());
		userInfo.setPassWord(EncryptUtils.getMD5(userInfo.getPassWord()));
		logger.info(userInfo.getUserName());
		boolean flag = userService.register(userInfo);
		return JSON.parseObject("{'flag':" + flag + "}");
	}

	@RequestMapping(value = "/to_login", method = RequestMethod.GET)
	public ModelAndView toLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/system/login/login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(SysUserInfo userInfo) {
		ModelAndView mv = new ModelAndView();
		userInfo.setPassWord(EncryptUtils.getMD5(userInfo.getPassWord()));
		List<SysUserInfo> result = loginService.login(userInfo);
		logger.info(result.size());
		if (result.size() > 0) {
			mv.addObject("userInfo", result.get(0));
			mv.setViewName("/system/login/index");
			mv.addObject("message", "登录成功！");
		} else {
			mv.setViewName("/system/login/login");
			mv.addObject("message", "账号或密码错误！");
		}
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/register/checkUserName", method = RequestMethod.POST)
	public JSON checkUserName(String userName) {
		SysUserInfo userInfo = new SysUserInfo();
		userInfo.setUserName(userName);

		boolean flag = loginService.checkUserName(userInfo, "userName");
		logger.info(flag);
		return JSON.parseObject("{'flag':" + flag + "}");
	}

	@ResponseBody
	@RequestMapping(value = "/register/checkEmail", method = RequestMethod.POST)
	public JSON checkEmail(String emailAddress) {
		SysUserInfo userInfo = new SysUserInfo();
		userInfo.setEmailAddress(emailAddress);

		boolean flag = loginService.checkUserName(userInfo, "emailAddress");
		logger.info(flag);
		return JSON.parseObject("{'flag':" + flag + "}");
	}

	@RequestMapping(value = "/logins", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("message", "ss");
		return mv;
	}

	// @RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		// List<Map<String, Object>> result = null;// loginService.search();

		String message = "";
		// for (Map<String, Object> map : result) {
		// message += map.get("JOBNAME") == null ? "" :
		// map.get("JOBNAME").toString();
		// message += " ;";
		// }
		mv.addObject("message", message);
		mv.setViewName("hello");
		return mv;
	}

	public SysUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(SysUserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
