package com.codingz.quote.idao;

import java.util.List;


import com.codingz.quote.model.FavorBoard;

public interface IFavorBoardDAO {
	
	public FavorBoard findById(Long id)throws Exception;
	public List<FavorBoard> findAll()throws Exception;
	public boolean save(FavorBoard favorBoard)throws Exception;
	public boolean update(FavorBoard favorBoard)throws Exception;
	public boolean delete(FavorBoard favorBoard)throws Exception;
	public List<FavorBoard> findCheckByuserIdAndQuoteId(Long userId,Long quoteId)throws Exception;
	public FavorBoard checkByUserIdAndQuoteId(Long userId,Long quoteId)throws Exception;
	public List<FavorBoard> findByUserId(Long userId)throws Exception;

}
