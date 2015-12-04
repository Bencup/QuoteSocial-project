package com.codingz.quote.dao;

import java.util.List;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.codingz.quote.idao.ICreditAuthorDAO;
import com.codingz.quote.model.CreditAuthor;

@Repository
public class CreditAuthorDAO extends HibernateDaoSupport implements ICreditAuthorDAO {

	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	@Override
	public CreditAuthor findById(Long id) throws Exception {
		CreditAuthor creditAuthor = this.getHibernateTemplate().get(CreditAuthor.class, id);
		return creditAuthor;
	}

	@Override
	public List<CreditAuthor> findAll() throws Exception {
		List<CreditAuthor> creditAuthorList = session.createCriteria(CreditAuthor.class).list();
		session.flush();
		session.clear();
		return creditAuthorList;
	}

	@Override
	public boolean save(CreditAuthor creditAuthor) throws Exception {
		this.getHibernateTemplate().save(creditAuthor);
		return true;
	}

	@Override
	public boolean update(CreditAuthor creditAuthor) throws Exception {
		this.getHibernateTemplate().update(creditAuthor);
		return true;
	}

	@Override
	public boolean delete(CreditAuthor creditAuthor) throws Exception {
		this.getHibernateTemplate().delete(creditAuthor);
		return true;
	}

	@Override
	public CreditAuthor findByCreditAuthorName(String creditAuthorName)
			throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CreditAuthor.class);
		detachedCriteria.add(Restrictions.eq("creditAuthorName",creditAuthorName));
		List<CreditAuthor> creditAuthorList = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		CreditAuthor creditAuthor = creditAuthorList.get(0);
		return creditAuthor;
		
	}

	
}
