package org.examples.spring.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.examples.spring.manager.LoginService;
import org.examples.spring.manager.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/hello")
	public String hello() {
		try {
			loginService.search();
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		return "hello";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("message", "顶顶顶顶");
		return mv;
	}

	// @RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		List<Map<String, Object>> result = loginService.search();

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
