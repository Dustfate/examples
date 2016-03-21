package org.examples.spring.manager.impl;

import java.util.List;
import java.util.Map;

import org.examples.spring.dao.BaseDao;
import org.examples.spring.manager.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional  
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private BaseDao baseDao;

	public List<Map<String, Object>> search() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ID_JOB, CHANNEL_ID, JOBNAME, STATUS, ERRORS, EXECUTING_SERVER, ");
		sql.append(" EXECUTING_USER, START_JOB_ENTRY, CLIENT ");
		sql.append(" FROM C##KETTLE.T_TEST ");
		return baseDao.search(sql.toString());
	}

}
