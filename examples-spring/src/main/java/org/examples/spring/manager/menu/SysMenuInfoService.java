package org.examples.spring.manager.menu;

import java.util.List;
import java.util.Map;

import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.web.DataTablesOptions;

/**
 * 菜单信息管理
 * @author Dusf
 *
 */
public interface SysMenuInfoService {

	/**
	 * 保存菜单信息
	 * @param menuInfo
	 * @return
	 */
	public abstract Long save(SysMenuInfo menuInfo);

	/**
	 * 插入菜单信息
	 * @param menuInfo
	 * @return
	 */
	public abstract Long insert(SysMenuInfo menuInfo);

	/**
	 * 删除菜单信息
	 * @param menuInfo
	 * @return
	 */
	public abstract int deleteSysMenuInfo(SysMenuInfo menuInfo);

	/**
	 * 更新菜单信息
	 * @param menuInfo
	 * @return
	 */
	public abstract int update(SysMenuInfo menuInfo);

	/**
	 * 获取菜单列表
	 * @param menuInfo
	 * @return
	 */
	public List<Map<String, Object>> findList(SysMenuInfo menuInfo);

	/**
	 * 获取菜单列表（带分页）
	 * @param menuInfo
	 * @param dataTablesOptions 分页信息
	 * @return
	 */
	public List<SysMenuInfo> findPageList(SysMenuInfo menuInfo, DataTablesOptions<SysMenuInfo> dataTablesOptions);
	
	/**
	 * 获取总条数
	 * @param menuInfo
	 * @return
	 * @throws Exception
	 */
	public int getCount(SysMenuInfo menuInfo);
}
