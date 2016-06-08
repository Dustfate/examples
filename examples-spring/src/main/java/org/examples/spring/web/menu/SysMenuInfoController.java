package org.examples.spring.web.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.manager.menu.SysMenuInfoService;
import org.examples.spring.util.StringUtil;
import org.examples.spring.web.DataTablesOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.dexcoder.commons.pager.Pager;

@RestController
@RequestMapping(value = "/menu")
public class SysMenuInfoController {
	private static final Logger logger = Logger.getLogger(SysMenuInfoController.class);
	private SysMenuInfo menuInfo;
	private String curPageNumber;
	private Pager pager;
	
	@Autowired
	private SysMenuInfoService sysMenuInfoService;
	@Autowired
	private  HttpServletRequest request;

	@RequestMapping(value = "/to_menu_list")
	public ModelAndView toMenuList() {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("/system/menu/menu_list");
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		logger.info("跳转到菜单列表页。。。");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/get_menu_list", method = {RequestMethod.POST, RequestMethod.GET})
	public Object getMenuList(SysMenuInfo menuInfo, DataTablesOptions<SysMenuInfo> dataTablesOptions) {
		String sortOrder = request.getParameter("order[0][column]");
		//排序方式
		String sortDir = request.getParameter("order[0][dir]");
		//排序字段
		String columnName = StringUtil.underscoreName(request.getParameter("columns["+sortOrder+"][data]"));
		logger.info("排序字段："+columnName);
		logger.info("排序方式："+sortDir);
		Pager pageResult = sysMenuInfoService.findMenuInfoPageList(menuInfo, dataTablesOptions, columnName, sortDir);
		
		DataTablesOptions<SysMenuInfo> result = new DataTablesOptions<SysMenuInfo>();
		result.setDraw(dataTablesOptions.getDraw());
		result.setData(pageResult.getList(SysMenuInfo.class));
		result.setRecordsTotal(pageResult.getItemsTotal());
		result.setRecordsFiltered(pageResult.getItemsTotal());
		Object json = null;
		try {
			json = JSONObject.toJSON(result);
		} catch (Exception e) {
			result.setError(e.getMessage());
			e.printStackTrace();
			json = JSONObject.toJSON(result);
		}
		
		logger.info("执行菜单列表页。。。");
		return json;
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

	public String getCurPageNumber() {
		return curPageNumber;
	}

	public void setCurPageNumber(String curPageNumber) {
		this.curPageNumber = curPageNumber;
	}

	
}
