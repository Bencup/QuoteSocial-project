package com.codingz.quote.service;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.quote.idao.IBoardDAO;
import com.codingz.quote.iservice.IBoardService;
import com.codingz.quote.model.Board;

@Service
@Transactional
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardDAO boardDAO;

	@Override
	public Board findById(Long id) throws Exception {
		return boardDAO.findById(id);
	}

	@Override
	public List<Board> findAll() throws Exception {
		return boardDAO.findAll();
	}

	@Override
	public boolean save(Board board) throws Exception {
		return boardDAO.save(board);
	}

	@Override
	public boolean update(Board board) throws Exception {
		return boardDAO.update(board);
	}

	@Override
	public boolean delete(Board board) throws Exception {
		return boardDAO.delete(board);
	}

	

}
