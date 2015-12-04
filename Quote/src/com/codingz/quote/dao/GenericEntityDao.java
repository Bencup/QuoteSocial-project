package com.codingz.quote.dao;

import java.io.Serializable;

import java.util.Collection;

import org.springframework.orm.hibernate4.HibernateCallback;

public interface GenericEntityDao {

	Serializable save(Object entity);

	void saveOrUpdate(Object entity);

	void update(Object entity);

	int bulkUpdate(String hql);

	int bulkUpdate(String hql, Object value);

	int bulkUpdate(String hql, Object[] values);

	void delete(Object entity); 
		

	<T> void deleteAll(Collection<T> entities);

	void persist(Object entity);

	void flush();

	void clear();

	@SuppressWarnings("rawtypes")
	Object execute(HibernateCallback action);
}
