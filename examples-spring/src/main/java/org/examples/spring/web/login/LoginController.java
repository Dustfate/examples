package org.examples.spring.web.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.examples.spring.entity.user.Users;
import org.examples.spring.manager.login.LoginService;
import org.examples.spring.support.I18nManager;
import org.examples.spring.web.RestfulResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.commons.utils.UUIDUtils;

@RestController
@RequestMapping
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;

	@RequestMapping("/hello")
	public String hello() {
		try {
			//loginService.search();
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		return "hello";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(Users users){
		
		logger.info(users.getUsername());
	}
	
	@RequestMapping("/login")
	public RestfulResponse getNodeList(Users users) {
        RestfulResponse restfulResponse = new RestfulResponse();
        List<String> list = new ArrayList<String>();
        list.add("aaaa");
        list.add("bbbb");
        
        restfulResponse.setSuccess(true);
        restfulResponse.setResults(1);
        restfulResponse.setRows(list);
        restfulResponse.setMsg(I18nManager.getMessage("node.dose.not.alive")+"，测试……");
        
        logger.info(users.getUsername());
        users.setUsreId(UUIDUtils.getUUID32());
        loginService.login(users.getUsername(), users.getPassword());

        loginService.login(users);
        return restfulResponse;
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

		List<Map<String, Object>> result = null;//loginService.search();

		String message = "";
		for (Map<String, Object> map : result) {
			message += map.get("JOBNAME") == null ? "" : map.get("JOBNAME").toString();
			message += " ;";
		}
		mv.addObject("message", message);
		mv.setViewName("hello");
		return mv;
	}

	
}
