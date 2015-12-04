package com.codingz.quote.dao;

import java.util.List;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.quote.idao.IFavorBoardDAO;
import com.codingz.quote.model.FavorBoard;
import com.codingz.quote.util.BeanUtils;

@Repository
public class FavorBoardDAO extends HibernateDaoSupport implements IFavorBoardDAO {

	protected Session session;
	
	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	
	private GenericFinderDao genericFinderDao; // for find

	
	private GenericEntityDao genericEntityDao; // for save delete update

	@Override
	public FavorBoard findById(Long id) throws Exception {
		FavorBoard favorBoard  = this.getHibernateTemplate().get(FavorBoard.class, id);
		return favorBoard;
	}

	@Override
	public List<FavorBoard> findAll() throws Exception {
		List<FavorBoard> faborBoardList = session.createCriteria(FavorBoard.class).list();
		session.flush();
		session.clear();
		return faborBoardList;
	}

	@Override
	public boolean save(FavorBoard favorBoard) throws Exception {
		this.getHibernateTemplate().save(favorBoard);
		return true;
	}

	@Override
	public boolean update(FavorBoard favorBoard) throws Exception {
		this.getHibernateTemplate().update(favorBoard);
		return true;
	}

	@Override
	public boolean delete(FavorBoard favorBoard) throws Exception {
		this.getHibernateTemplate().delete(favorBoard);
		return true;
	}

	@Override
	public List<FavorBoard> findCheckByuserIdAndQuoteId(Long userId, Long quoteId)
			throws Exception {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FavorBoard.class,"favor");
		detachedCriteria.createAlias("favor.user", "user");
		detachedCriteria.createAlias("favor.board", "board");
		
		detachedCriteria.add(Restrictions.eq("user.id", userId));
		detachedCriteria.add(Restrictions.eq("board.id", quoteId));
		
		FavorBoard favorBoard = null;
		List<FavorBoard> results = getHibernateTemplate().findByCriteria(detachedCriteria);
		
		return results;
	}

	@Override
	public FavorBoard checkByUserIdAndQuoteId(Long userId, Long quoteId)
			throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FavorBoard.class,"favor");
		detachedCriteria.createAlias("favor.user", "user");
		detachedCriteria.createAlias("favor.board", "board");
		
		detachedCriteria.add(Restrictions.eq("user.id", userId));
		detachedCriteria.add(Restrictions.eq("board.id", quoteId));
		
		FavorBoard favorBoard = null;
		List<FavorBoard> results = genericFinderDao.findByCriteria(detachedCriteria);
		if (BeanUtils.isNotEmpty(results)) {
			favorBoard = results.get(0);
		}		
		return favorBoard;
	}

	@Override
	public List<FavorBoard> findByUserId(Long userId) throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FavorBoard.class,"favor");
		detachedCriteria.createAlias("favor.user", "user");
		
		detachedCriteria.add(Restrictions.eq("user.id", userId));
		
		FavorBoard favorBoard = null;
		List<FavorBoard> results = getHibernateTemplate().findByCriteria(detachedCriteria);
		
		return results;
	}
}
