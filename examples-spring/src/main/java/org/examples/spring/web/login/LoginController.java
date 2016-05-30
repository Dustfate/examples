package org.examples.spring.web.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.examples.spring.entity.user.UserInfo;
import org.examples.spring.manager.login.LoginService;
import org.examples.spring.support.I18nManager;
import org.examples.spring.web.RestfulResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dexcoder.commons.utils.UUIDUtils;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	public void writeJson(Object object) {
		try {

			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
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
	public void register(UserInfo userInfo) {
		userInfo.setUsreId(UUIDUtils.getUUID32());
		userInfo.setCreateDate(new Date());
		logger.info(userInfo.getUserName());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(UserInfo userInfo) {
		ModelAndView mv = new ModelAndView();

		boolean isLogin = loginService.login(userInfo);
		logger.info(isLogin);
		if (isLogin) {
			mv.setViewName("/index");
			mv.addObject("message", "登录成功！");
		} else {
			mv.addObject("message", "登录失败！");
		}
		return mv;
	}

	@RequestMapping("/loginss")
	public RestfulResponse getNodeList(String username, String password) {
		RestfulResponse restfulResponse = new RestfulResponse();
		List<String> list = new ArrayList<String>();
		list.add("aaaa");
		list.add("bbbb");

		restfulResponse.setSuccess(true);
		restfulResponse.setResults(1);
		restfulResponse.setRows(list);
		restfulResponse.setMsg(I18nManager.getMessage("node.dose.not.alive") + "，测试……");

		UserInfo userInfo = new UserInfo();
		userInfo.setUsreId(UUIDUtils.getUUID32());
		userInfo.setUserName(username);
		userInfo.setPassWord(password);
		logger.info(userInfo.getUserName());
		loginService.login(userInfo);
		return restfulResponse;
	}

	@RequestMapping(value = "/register/checkUserName", method = RequestMethod.POST)
	public void checkUserName(String userName) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userName);

		boolean flag = loginService.checkUserName(userInfo);
		logger.info(flag);
	}

	@RequestMapping(value = "/logins", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("message", "ss");
		return mv;
	}

	// @RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

//		List<Map<String, Object>> result = null;// loginService.search();

		String message = "";
//		for (Map<String, Object> map : result) {
//			message += map.get("JOBNAME") == null ? "" : map.get("JOBNAME").toString();
//			message += " ;";
//		}
		mv.addObject("message", message);
		mv.setViewName("hello");
		return mv;
	}

}
