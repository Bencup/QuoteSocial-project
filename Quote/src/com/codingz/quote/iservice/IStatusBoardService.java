package com.codingz.quote.iservice;

import java.util.List;

import com.codingz.quote.model.StatusBoard;


public interface IStatusBoardService {
	
	public StatusBoard findById(Long id)throws Exception;
	public List<StatusBoard> findAll()throws Exception;
	public boolean save(StatusBoard statusBoard)throws Exception;
	public boolean update(StatusBoard statusBoard)throws Exception;
	public boolean delete(StatusBoard statusBoard)throws Exception;

}
