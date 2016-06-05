package org.examples.spring.dao.menu;

import java.util.List;
import java.util.Map;

import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.web.DataTablesOptions;

public interface SysMenuInfoDao {

	public abstract Long save(SysMenuInfo menuInfo) throws Exception;

	public abstract Long insert(SysMenuInfo menuInfo) throws Exception;

	public abstract int deleteSysMenuInfo(SysMenuInfo menuInfo) throws Exception;

	public abstract int update(SysMenuInfo menuInfo) throws Exception;

	public List<Map<String, Object>> findList(SysMenuInfo menuInfo) throws Exception;

	public List<SysMenuInfo> findPageList(SysMenuInfo menuInfo, DataTablesOptions<SysMenuInfo> dataTablesOptions) throws Exception;
	
	public List<SysMenuInfo> getCount(SysMenuInfo menuInfo) throws Exception;
}
