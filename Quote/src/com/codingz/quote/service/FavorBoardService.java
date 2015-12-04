package com.codingz.quote.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.quote.idao.IFavorBoardDAO;
import com.codingz.quote.iservice.IFavorBoardService;
import com.codingz.quote.model.FavorBoard;

@Service
@Transactional
public class FavorBoardService implements IFavorBoardService {
	
	@Autowired
	private IFavorBoardDAO favorBoardDAO;

	@Override
	public FavorBoard findById(Long id) throws Exception {
		return favorBoardDAO.findById(id);
	}

	@Override
	public List<FavorBoard> findAll() throws Exception {
		return favorBoardDAO.findAll();
	}

	@Override
	public boolean save(FavorBoard favorBoard) throws Exception {
		return  favorBoardDAO.save(favorBoard);
	}

	@Override
	public boolean update(FavorBoard favorBoard) throws Exception {
		return favorBoardDAO.update(favorBoard);
	}

	@Override
	public boolean delete(FavorBoard favorBoard) throws Exception {
		return favorBoardDAO.delete(favorBoard);
	}

	@Override
	public List<FavorBoard> findCheckByuserIdAndQuoteId(Long userId, Long quoteId)
			throws Exception {
		return favorBoardDAO.findCheckByuserIdAndQuoteId(userId, quoteId);
	}

	@Override
	public FavorBoard checkByUserIdAndQuoteId(Long userId, Long quoteId)
			throws Exception {
		
		return favorBoardDAO.checkByUserIdAndQuoteId(userId, quoteId);
	}

	@Override
	public List<FavorBoard> findByUserId(Long userId) throws Exception {
		return favorBoardDAO.findByUserId(userId);
	}

	

}
