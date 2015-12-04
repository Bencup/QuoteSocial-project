package com.codingz.quote.idao;

import java.util.List;


import com.codingz.quote.model.CreditAuthor;

public interface ICreditAuthorDAO {
	
	public CreditAuthor findById(Long id)throws Exception;
	public List<CreditAuthor> findAll()throws Exception;
	public boolean save(CreditAuthor creditAuthor)throws Exception;
	public boolean update(CreditAuthor creditAuthor)throws Exception;
	public boolean delete(CreditAuthor creditAuthor)throws Exception;
	public CreditAuthor findByCreditAuthorName(String creditAuthorName)throws Exception;
		

}
