package org.examples.spring.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseDao extends JdbcDaoSupport {
	
	/**
	 * 查询
	 * @param sql
	 * @return
	 */
	public List<Map<String,Object>> search(String sql){
		return this.getJdbcTemplate().queryForList(sql);
	}
	
}