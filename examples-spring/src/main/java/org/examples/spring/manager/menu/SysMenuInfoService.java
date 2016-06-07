package org.examples.spring.manager.menu;

import java.util.List;

import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.web.DataTablesOptions;

/**
 * 菜单信息管理
 * 
 * @author Dusf
 *
 */
public interface SysMenuInfoService {

	/**
	 * 保存菜单信息
	 * 
	 * @param menuInfo
	 * @return
	 */
	public abstract Long saveMenuInfo(SysMenuInfo menuInfo);

	/**
	 * 插入菜单信息
	 * 
	 * @param menuInfo
	 * @return
	 */
	public abstract Long insertMenuInfo(SysMenuInfo menuInfo);

	/**
	 * 删除菜单信息
	 * 
	 * @param menuInfo
	 * @return
	 */
	public abstract int deleteSysMenuInfo(SysMenuInfo menuInfo);

	/**
	 * 更新菜单信息
	 * 
	 * @param menuInfo
	 * @return
	 */
	public abstract int updateMenuInfo(SysMenuInfo menuInfo);
	

	/**
	 * 获取菜单树
	 * @param menuInfo
	 * @return
	 */
	public List<SysMenuInfo> findMenuInfoTreeList(SysMenuInfo menuInfo);

	/**
	 * 获取菜单列表
	 * 
	 * @param menuInfo
	 * @return
	 */
	public List<SysMenuInfo> findMenuInfoList(SysMenuInfo menuInfo);

	/**
	 * 获取菜单列表（带分页）
	 * 
	 * @param menuInfo
	 * @param dataTablesOptions
	 * @param columnName
	 *            排序列名
	 * @param sortDir
	 *            排序方式
	 * @param searchValue
	 *            查询条件
	 * @return
	 */
	public List<SysMenuInfo> findMenuInfoPageList(SysMenuInfo menuInfo,
			DataTablesOptions<SysMenuInfo> dataTablesOptions,
			String columnName, String sortDir);

	/**
	 * 获取总条数
	 * 
	 * @param menuInfo
	 * @return
	 * @throws Exception
	 */
	public int getCount(SysMenuInfo menuInfo);
}
