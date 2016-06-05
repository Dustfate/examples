package org.examples.spring.web.menu;

import java.util.List;

import org.apache.log4j.Logger;
import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.manager.menu.SysMenuInfoService;
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

	@RequestMapping(value = "/to_menu_list")
	public ModelAndView toMenuList() {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("/system/menu/menu_list");
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/get_menu_list", method = {RequestMethod.POST, RequestMethod.GET})
	public Object getMenuList(SysMenuInfo menuInfo, DataTablesOptions<SysMenuInfo> dataTablesOptions) {
		// For sortable
//		String sortOrder = request.getParameter("order[0][column]");
//		String sortDir = request.getParameter("order[0][dir]");
//		System.out.println("sortOrder: " + sortOrder);
//		System.out.println("sortDir: " + sortDir);
		// For search
//		String searchValue = request.getParameter("search[value]");
		//results = dao.loadDataList(pageSize, startRecord, columnsName[Integer.parseInt(sortOrder)], sortDir, searchValue);
		List<SysMenuInfo> menuList = sysMenuInfoService.findPageList(menuInfo, dataTablesOptions);
		int count = sysMenuInfoService.getCount(menuInfo);
		
		DataTablesOptions<SysMenuInfo> result = new DataTablesOptions<SysMenuInfo>();
		result.setDraw(dataTablesOptions.getDraw());
		result.setData(menuList);
		result.setRecordsTotal(count);
		result.setRecordsFiltered(count);
		Object json = JSONObject.toJSON(result);
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
