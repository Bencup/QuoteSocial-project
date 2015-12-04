package com.codingz.quote.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.quote.idao.IBoardDAO;
import com.codingz.quote.model.Board;
import com.codingz.simplemember.model.Borrow;

@Repository
public class BoardDAO extends HibernateDaoSupport implements IBoardDAO {

	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	@Override
	public Board findById(Long id) throws Exception {
		Board board = this.getHibernateTemplate().get(Board.class, id);
		return board;
	}

	@Override
	public List<Board> findAll() throws Exception {
		List<Board> boardList = session.createCriteria(Board.class).list();
		session.flush();
		session.clear();
		return boardList;
	}

	@Override
	public boolean save(Board board) throws Exception {
		this.getHibernateTemplate().save(board);
		return true;
	}

	@Override
	public boolean update(Board board) throws Exception {
		this.getHibernateTemplate().update(board);
		return true;
	}

	@Override
	public boolean delete(Board board) throws Exception {
		this.getHibernateTemplate().delete(board);
		return true;
	}

	
}
