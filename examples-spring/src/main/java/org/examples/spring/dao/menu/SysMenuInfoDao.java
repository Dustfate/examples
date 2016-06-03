package org.examples.spring.dao.menu;

import java.util.List;
import java.util.Map;

import org.examples.spring.entity.menu.SysMenuInfo;

import com.dexcoder.commons.pager.Pager;

public interface SysMenuInfoDao {

	public abstract Long save(SysMenuInfo menuInfo);

	public abstract Long insert(SysMenuInfo menuInfo);

	public abstract int deleteSysMenuInfo(SysMenuInfo menuInfo);

	public abstract int update(SysMenuInfo menuInfo);

	public List<Map<String, Object>> findList(SysMenuInfo menuInfo);

	public List<SysMenuInfo> findPageList(SysMenuInfo menuInfo, Pager pager);
}
