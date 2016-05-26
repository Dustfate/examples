package org.examples.spring.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseDao extends JdbcDaoSupport implements SuperDao {

	/**
	 * 查询
	 * 
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> search(String sql) {
		return this.getJdbcTemplate().queryForList(sql);
	}

	@Override
	public SuperDao include(String... field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuperDao exclude(String... field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuperDao asc(String... field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuperDao desc(String... field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuperDao set(String fieldName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuperDao where(String fieldName, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuperDao whereAssign(String fieldName, String operator,
			Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Class<?> clazz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Class<?> clazz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> List<T> query(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(Object entity) {
		
		return null;
	}

	@Override
	public void add(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Class<?> clazz, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Class<?> clazz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T getById(Class<T> clazz, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T querySingleResult(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryCount(Object entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> List<T> queryList(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	
}