package com.codingz.quote.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.quote.idao.IStatusBoardDAO;
import com.codingz.quote.model.StatusBoard;

@Repository
public class StatusBoardDAO extends HibernateDaoSupport implements IStatusBoardDAO {

	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	@Override
	public StatusBoard findById(Long id) throws Exception {
		StatusBoard statusBoard = this.getHibernateTemplate().get(StatusBoard.class, id);
		return statusBoard;
	}

	@Override
	public List<StatusBoard> findALl() throws Exception {
		List<StatusBoard> statusBoardList = session.createCriteria(StatusBoard.class).list();
		session.flush();
		session.clear();
		return statusBoardList;
	}

	@Override
	public boolean save(StatusBoard statusBoard) throws Exception {
		this.getHibernateTemplate().save(statusBoard);
		return true;
	}

	@Override
	public boolean update(StatusBoard statusBoard) throws Exception {
		this.getHibernateTemplate().update(statusBoard);
		return true;
	}

	@Override
	public boolean delete(StatusBoard statusBoard) throws Exception {
		this.getHibernateTemplate().delete(statusBoard);
		return true;
	}

	
	
}
