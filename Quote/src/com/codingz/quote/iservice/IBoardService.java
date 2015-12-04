package com.codingz.quote.iservice;

import java.util.List;


import com.codingz.quote.model.Board;


public interface IBoardService {
	
	public Board findById(Long id)throws Exception;
	public List<Board> findAll()throws Exception;
	public boolean save(Board board)throws Exception;
	public boolean update(Board board)throws Exception;
	public boolean delete(Board board)throws Exception;
	
}
