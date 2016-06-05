package org.examples.spring.manager.menu.impl;

import java.util.List;
import java.util.Map;

import org.examples.spring.dao.menu.SysMenuInfoDao;
import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.manager.menu.SysMenuInfoService;
import org.examples.spring.web.DataTablesOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysMenuInfoService")
public class SysMenuInfoServiceImpl implements SysMenuInfoService {

	@Autowired
	private SysMenuInfoDao sysMenuInfoDao;

	@Override
	public Long save(SysMenuInfo menuInfo) {
		Long count = 0L;
		try {
			count = sysMenuInfoDao.save(menuInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Long insert(SysMenuInfo menuInfo) {

		return null;
	}

	@Override
	public int deleteSysMenuInfo(SysMenuInfo menuInfo) {
		int count = 0;
		try {
			count = sysMenuInfoDao.deleteSysMenuInfo(menuInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int update(SysMenuInfo menuInfo) {
		int count = 0;
		try {
			count = sysMenuInfoDao.update(menuInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Map<String, Object>> findList(SysMenuInfo menuInfo) {
		List<Map<String, Object>> result = null;
		try {
			result = sysMenuInfoDao.findList(menuInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<SysMenuInfo> findPageList(SysMenuInfo menuInfo, DataTablesOptions<SysMenuInfo> dataTablesOptions) {
		List<SysMenuInfo> result = null;
		try {
			result = sysMenuInfoDao.findPageList(menuInfo, dataTablesOptions);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int getCount(SysMenuInfo menuInfo) {
		int result = 0;
		try {
			result = sysMenuInfoDao.getCount(menuInfo).size();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	

}
