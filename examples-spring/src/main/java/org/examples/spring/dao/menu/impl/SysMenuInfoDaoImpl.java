package org.examples.spring.dao.menu.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.examples.spring.dao.BaseDao;
import org.examples.spring.dao.login.impl.LoginDaoImpl;
import org.examples.spring.dao.menu.SysMenuInfoDao;
import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.commons.pager.Pager;
import com.dexcoder.dal.spring.JdbcDaoImpl;
import com.dexcoder.dal.spring.page.PageControl;

/**
 * 系统菜单管理
 * 
 * @author dusf
 *
 */
@Repository
@Transactional
public class SysMenuInfoDaoImpl implements SysMenuInfoDao {

	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	@Autowired
	private BaseDao baseDao;
	@Autowired
	private JdbcDaoImpl jdbcDaoImpl;
	@Autowired
	private PageControl pageControl;

	@Override
	public Long save(SysMenuInfo menuInfo) {
		Long count = 0L;
		try {
			jdbcDaoImpl.save(menuInfo);
			count = 1L;
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		}
		return count;
	}

	@Override
	public Long insert(SysMenuInfo menuInfo) {

		return null;
	}

	@Override
	public int deleteSysMenuInfo(SysMenuInfo menuInfo) {
		return jdbcDaoImpl.delete(menuInfo);
	}

	@Override
	public int update(SysMenuInfo menuInfo) {
		return jdbcDaoImpl.update(menuInfo);
	}

	@Override
	public List<Map<String, Object>> findList(SysMenuInfo menuInfo) {
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MENU_ID, MENU_NAME, PARENT_ID, MENU_URL, MENU_ORDER, MENU_ICON, MENU_TYPE, ISENABLE, CREATE_TIME, UPDATE_TIME ");
		sql.append(" FROM SYS_MENU_INFO ");
		sql.append(" where 1=1");

		if (StringUtil.isEmpty(menuInfo.getMenuName())) {
			sql.append(" AND MENU_NAME LIKE ? ");
			params.add("'%" + menuInfo.getMenuName() + "%'");
		}

		if (StringUtil.isEmpty(menuInfo.getIsEnable())) {
			sql.append(" AND ISENABLE = ? ");
			params.add(menuInfo.getIsEnable());
		}

		List<Map<String, Object>> list = null;
		try {
			list = jdbcDaoImpl.queryListForSql(sql.toString(), params.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(list.size());
		return list;
	}
	
	public List<SysMenuInfo> findPageList(SysMenuInfo menuInfo,Pager pager){
		//直接传入页码和每页条数
		pageControl.performPage(pager.getCurPage(), pager.getItemsPerPage());
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MENU_ID, MENU_NAME, PARENT_ID, MENU_URL, MENU_ORDER, MENU_ICON, MENU_TYPE, IS_ENABLE, CREATE_TIME, UPDATE_TIME ");
		sql.append(" FROM SYS_MENU_INFO ");
		sql.append(" where 1=1");
		if (!StringUtil.isEmpty(menuInfo.getMenuName())) {
			sql.append(" AND MENU_NAME LIKE ? ");
			params.add("'%" + menuInfo.getMenuName() + "%'");
		}

		if (!StringUtil.isEmpty(menuInfo.getIsEnable())) {
			sql.append(" AND ISENABLE = ? ");
			params.add(menuInfo.getIsEnable());
		}

		List<SysMenuInfo> list = null;
		try {
			jdbcDaoImpl.queryListForSql(sql.toString(), SysMenuInfo.class);
			pager = PageControl.getPager();
			list = (List<SysMenuInfo>) pager.getList(SysMenuInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
