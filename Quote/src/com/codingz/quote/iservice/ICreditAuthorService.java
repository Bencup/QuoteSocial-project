package com.codingz.quote.iservice;

import java.util.List;

import com.codingz.quote.model.CreditAuthor;



public interface ICreditAuthorService {
	
	public CreditAuthor findById(Long id)throws Exception;
	public List<CreditAuthor> findAll()throws Exception;
	public boolean save(CreditAuthor creditAuthor)throws Exception;
	public boolean update(CreditAuthor creditAuthor)throws Exception;
	public boolean delete(CreditAuthor creditAuthor)throws Exception;
	public CreditAuthor findByCreditAuthorName(String creditAuthorName)throws Exception;

}
