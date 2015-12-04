package com.codingz.quote.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.quote.idao.ICategoriesDAO;
import com.codingz.quote.model.Categories;

@Repository
public class CategoriesDAO extends HibernateDaoSupport implements ICategoriesDAO {

	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	@Override
	public Categories findById(Long id) throws Exception {
		Categories categories = this.getHibernateTemplate().get(Categories.class, id);
		return categories;
	}

	@Override
	public List<Categories> findAll() throws Exception {
		List<Categories> categoriesList = session.createCriteria(Categories.class).list();
		session.flush();
		session.clear();
		return categoriesList;
	}

	@Override
	public boolean save(Categories categories) throws Exception {
		this.getHibernateTemplate().save(categories);
		return true;
	}

	@Override
	public boolean update(Categories categories) throws Exception {
		this.getHibernateTemplate().update(categories);
		return true;
	}

	@Override
	public boolean delete(Categories categories) throws Exception {
		this.getHibernateTemplate().delete(categories);
		return true;
	}

	
}
