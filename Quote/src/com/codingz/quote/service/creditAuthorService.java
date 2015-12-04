package com.codingz.quote.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.quote.idao.ICreditAuthorDAO;
import com.codingz.quote.iservice.ICreditAuthorService;
import com.codingz.quote.model.CreditAuthor;


@Service
@Transactional
public class creditAuthorService implements ICreditAuthorService {
	
	@Autowired
	private ICreditAuthorDAO creditAuthorDAO;

	@Override
	public CreditAuthor findById(Long id) throws Exception {
		return creditAuthorDAO.findById(id);
	}

	@Override
	public List<CreditAuthor> findAll() throws Exception {
		return creditAuthorDAO.findAll();
	}

	@Override
	public boolean save(CreditAuthor creditAuthor) throws Exception {
		return creditAuthorDAO.save(creditAuthor);
	}

	@Override
	public boolean update(CreditAuthor creditAuthor) throws Exception {
		return creditAuthorDAO.update(creditAuthor);
	}

	@Override
	public boolean delete(CreditAuthor creditAuthor) throws Exception {
		return creditAuthorDAO.delete(creditAuthor);
	}

	@Override
	public CreditAuthor findByCreditAuthorName(String creditAuthorName)
			throws Exception {
		return creditAuthorDAO.findByCreditAuthorName(creditAuthorName);
	}

	

}
