package org.examples.spring.web.menu;

import java.util.List;

import org.apache.log4j.Logger;
import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.manager.menu.SysMenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dexcoder.commons.pager.Pager;
import com.dexcoder.dal.spring.page.PageControl;

@RestController
@RequestMapping(value = "/menu")
public class SysMenuInfoController {
	private static final Logger logger = Logger.getLogger(SysMenuInfoController.class);
	private SysMenuInfo menuInfo;
	private Pager pager = new Pager();
	
	@Autowired
	private SysMenuInfoService sysMenuInfoService;

	@RequestMapping(value = "/menu_list", method = RequestMethod.GET)
	public ModelAndView login(SysMenuInfo menuInfo) {
		ModelAndView mv = new ModelAndView();
		pager.setCurPage(1);
		pager.setItemsPerPage(10);
		try {
			List<SysMenuInfo> menuList = sysMenuInfoService.findPageList(menuInfo, pager);
			mv.addObject("menuList", menuList);
			mv.setViewName("/system/menu/menu_list");
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/register/checkUserName", method = RequestMethod.POST)
	public JSON checkUserName(String userName) {

		return JSON.parseObject("{'flag': false }");
	}

	public SysMenuInfo getMenuInfo() {
		return menuInfo;
	}

	public void setMenuInfo(SysMenuInfo menuInfo) {
		this.menuInfo = menuInfo;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
}
