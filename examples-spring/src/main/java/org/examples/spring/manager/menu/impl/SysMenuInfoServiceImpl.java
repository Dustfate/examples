package org.examples.spring.manager.menu.impl;

import java.util.ArrayList;
import java.util.List;

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
	public Long saveMenuInfo(SysMenuInfo menuInfo) {
		Long count = 0L;
		try {
			count = sysMenuInfoDao.saveMenuInfo(menuInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Long insertMenuInfo(SysMenuInfo menuInfo) {

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
	public int updateMenuInfo(SysMenuInfo menuInfo) {
		int count = 0;
		try {
			count = sysMenuInfoDao.updateMenuInfo(menuInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<SysMenuInfo> findMenuInfoTreeList(SysMenuInfo menuInfo){
		List<SysMenuInfo> result = null;
		try {
			result = sysMenuInfoDao.findMenuInfoList(menuInfo);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<SysMenuInfo> findMenuInfoList(SysMenuInfo menuInfo) {
		List<SysMenuInfo> result = null;
		try {
			result = sysMenuInfoDao.findMenuInfoList(menuInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<SysMenuInfo> findMenuInfoPageList(SysMenuInfo menuInfo,
			DataTablesOptions<SysMenuInfo> dataTablesOptions,
			String columnName, String sortDir) {
		List<SysMenuInfo> result = null;
		try {
			result = sysMenuInfoDao.findMenuInfoPageList(menuInfo, dataTablesOptions,
					columnName, sortDir);
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
