package org.examples.spring.manager.menu.impl;

import java.util.List;
import java.util.Map;

import org.examples.spring.dao.menu.SysMenuInfoDao;
import org.examples.spring.entity.menu.SysMenuInfo;
import org.examples.spring.manager.menu.SysMenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexcoder.commons.pager.Pager;

@Service("sysMenuInfoService")
public class SysMenuInfoServiceImpl implements SysMenuInfoService {

	@Autowired
	private SysMenuInfoDao sysMenuInfoDao;

	@Override
	public Long save(SysMenuInfo menuInfo) {

		return sysMenuInfoDao.save(menuInfo);
	}

	@Override
	public Long insert(SysMenuInfo menuInfo) {

		return null;
	}

	@Override
	public int deleteSysMenuInfo(SysMenuInfo menuInfo) {
		return sysMenuInfoDao.deleteSysMenuInfo(menuInfo);
	}

	@Override
	public int update(SysMenuInfo menuInfo) {

		return sysMenuInfoDao.update(menuInfo);
	}

	@Override
	public List<Map<String, Object>> findList(SysMenuInfo menuInfo) {

		return sysMenuInfoDao.findList(menuInfo);
	}

	@Override
	public List<SysMenuInfo> findPageList(SysMenuInfo menuInfo, Pager pager) {
		
		return sysMenuInfoDao.findPageList(menuInfo, pager);
	}

	
}
