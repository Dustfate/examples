package org.examples.spring.dao.menu;

import java.util.List;

import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.web.DataTablesOptions;

public interface SysMenuInfoDao {

	public abstract Long saveMenuInfo(SysMenuInfo menuInfo) throws Exception;

	public abstract Long insertMenuInfo(SysMenuInfo menuInfo) throws Exception;

	public abstract int deleteSysMenuInfo(SysMenuInfo menuInfo)
			throws Exception;

	public abstract int updateMenuInfo(SysMenuInfo menuInfo) throws Exception;

	public List<SysMenuInfo> findMenuInfoList(SysMenuInfo menuInfo)
			throws Exception;

	public List<SysMenuInfo> findMenuInfoPageList(SysMenuInfo menuInfo,
			DataTablesOptions<SysMenuInfo> dataTablesOptions,
			String columnName, String sortDir) throws Exception;

	public List<SysMenuInfo> getCount(SysMenuInfo menuInfo) throws Exception;
}
