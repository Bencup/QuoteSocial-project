package com.codingz.quote.idao;

import java.util.List;


import com.codingz.quote.model.StatusBoard;

public interface IStatusBoardDAO {
	
	public StatusBoard findById(Long id)throws Exception;
	public List<StatusBoard> findALl()throws Exception;
	public boolean save(StatusBoard statusBoard)throws Exception;
	public boolean update(StatusBoard statusBoard)throws Exception;
	public boolean delete(StatusBoard statusBoard)throws Exception;

}
