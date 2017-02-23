package org.examples.spring.web.login;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.entity.user.SysUserInfo;
import org.examples.spring.manager.login.LoginService;
import org.examples.spring.manager.menu.SysMenuInfoService;
import org.examples.spring.manager.user.UserService;
import org.examples.spring.util.Const;
import org.examples.spring.util.EncryptUtils;
import org.examples.spring.web.BaseController;
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
public class LoginController extends BaseController {
	
	private SysUserInfo userInfo;
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	@Autowired
	private SysMenuInfoService sysMenuInfoService;

	@RequestMapping("/hello")
	public String hello() {
		try {
			// loginService.search();
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		return "hello";
	}

	@RequestMapping(value = "/to_login", method = RequestMethod.GET)
	public ModelAndView toLogin() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("/system/main/login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object login(SysUserInfo userInfo) {
		Map<String, String> map = new HashMap<String, String>();
		String errInfo = "";
		String password = EncryptUtils.getMD5(userInfo.getPassWord());
		userInfo.setPassWord(password);
		
		// shiro加入身份验证
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		logger.info("=================验证用户信息中==============");
		SysUserInfo result = loginService.login(userInfo);
		if (result != null && !"".equals(result)) {
			logger.info(result.getUserName());
			//添加最后的登录时间
			result.setUpdateDate(new Date());
			loginService.updateLoginTime(result);
			
			SysUserInfo user = new SysUserInfo();
			user.setUserId(result.getUserId());
			user.setUserName(result.getUserName());
			user.setPassWord(result.getPassWord());
			user.setEmailAddress(result.getEmailAddress());
			user.setPhoneNumber(result.getPhoneNumber());
			user.setCardId(result.getCardId());
			user.setRealName(result.getRealName());
			user.setStatus(result.getStatus());
			user.setIp(result.getIp());
			user.setSkin(result.getSkin());
			user.setCreateDate(result.getCreateDate());
			user.setUpdateDate(result.getUpdateDate());
			user.setLoginDate(result.getLoginDate());
			
			session.setAttribute(Const.SESSION_USER, user);
			session.removeAttribute(Const.SESSION_SECURITY_CODE);
			
			UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUserName(), password);
			//记住密码
			token.setRememberMe(true);
			try {
				currentUser.login(token);
				errInfo = "success"; // 验证成功
				logger.info("=================身份验证成功！==============");
			} catch(LockedAccountException lae){
				logger.info("对用户[" + userInfo.getUserName() + "]进行登录验证...验证未通过，账户已锁定");
	            errInfo = "账户已锁定";
	        } catch(ExcessiveAttemptsException eae){
	        	logger.info("对用户[" + userInfo.getUserName() + "]进行登录验证...验证未通过，错误次数过多");
	            errInfo = "用户名或密码错误次数过多";
	        } catch (AuthenticationException e) {
				errInfo = "身份验证失败！";
				logger.info("=================身份验证失败！==============");
			}
		} else {
			errInfo = "usererror"; // 用户名或密码有误
		}

		map.put("result", errInfo);
		return map;
	}
	
	/**
	 * 访问系统首页
	 */
	@RequestMapping(value = "/index")
	public ModelAndView login_index(){
		ModelAndView mv = this.getModelAndView();
		SysMenuInfo menuInfo = new SysMenuInfo();
		menuInfo.setIsEnable("1");
		menuInfo.setParentId("0");
		List<SysMenuInfo> menuList = sysMenuInfoService.findAllParentMenu(menuInfo);
		
		mv.addObject("menuList", menuList);
		
		mv.setViewName("/system/main/index");
		return mv;
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
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("login");
		mv.addObject("message", "ss");
		return mv;
	}

	// @RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = this.getModelAndView();

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
