package org.examples.ssh.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基础Dao类
 * @Title: BaseDaoI.java
 * @Package org.examples.ssh.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年4月26日 下午5:14:19
 * @param <T>
 */
public interface BaseDaoI<T> {

	/**
	 * 保存
	 * @param o
	 * @return
	 */
	public Serializable save(T o);

	/**
	 * 删除
	 * @param o
	 */
	public void delete(T o);

	/**
	 * 更新
	 * @param o
	 */
	public void update(T o);

	/**
	 * 保存或更新
	 * @param o
	 */
	public void saveOrUpdate(T o);

	/**
	 * 查询
	 * @param c
	 * @param id
	 * @return
	 */
	public T get(Class<T> c, Serializable id);

	public T get(String hql);

	public T get(String hql, Map<String, Object> params);

	public List<T> find(String hql);

	public List<T> find(String hql, Map<String, Object> params);

	public List<T> find(String hql, int page, int rows);

	public List<T> find(String hql, Map<String, Object> params, int page,
			int rows);

	public Long count(String hql);

	public Long count(String hql, Map<String, Object> params);

	public int executeHql(String hql);

}
