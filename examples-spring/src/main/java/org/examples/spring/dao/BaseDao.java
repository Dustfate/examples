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
		
		return null;
	}

	@Override
	public SuperDao exclude(String... field) {
		
		return null;
	}

	@Override
	public SuperDao asc(String... field) {
		
		return null;
	}

	@Override
	public SuperDao desc(String... field) {
		
		return null;
	}

	@Override
	public SuperDao set(String fieldName, Object value) {
		
		return null;
	}

	@Override
	public SuperDao where(String fieldName, Object... values) {
		
		return null;
	}

	@Override
	public SuperDao whereAssign(String fieldName, String operator, Object... values) {
		
		return null;
	}

	@Override
	public void update(Class<?> clazz) {
		

	}

	@Override
	public void delete(Class<?> clazz) {
		

	}

	@Override
	public <T> List<T> query(Class<T> clazz) {
		
		return null;
	}

	@Override
	public Long insert(Object entity) {

		return null;
	}

	@Override
	public void add(Object entity) {
		

	}

	@Override
	public void update(Object entity) {
		

	}

	@Override
	public void delete(Class<?> clazz, Long id) {
		

	}

	@Override
	public void delete(Object entity) {
		

	}

	@Override
	public void deleteAll(Class<?> clazz) {
		

	}

	@Override
	public <T> T getById(Class<T> clazz, Long id) {
		
		return null;
	}

	@Override
	public <T> T querySingleResult(T entity) {
		
		return null;
	}

	@Override
	public int queryCount(Object entity) {
		
		return 0;
	}

	@Override
	public <T> List<T> queryList(T entity) {
		
		return null;
	}

	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		
		return null;
	}

}