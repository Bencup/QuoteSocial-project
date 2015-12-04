package com.codingz.quote.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.quote.idao.IStatusBoardDAO;
import com.codingz.quote.iservice.IStatusBoardService;
import com.codingz.quote.model.StatusBoard;

@Service
@Transactional
public class StatusBoardService implements IStatusBoardService {
	
	@Autowired
	private IStatusBoardDAO statusBoardDAO;

	@Override
	public StatusBoard findById(Long id) throws Exception {
		return statusBoardDAO.findById(id);
	}

	@Override
	public List<StatusBoard> findAll() throws Exception {
		return statusBoardDAO.findALl();
	}

	@Override
	public boolean save(StatusBoard statusBoard) throws Exception {
		return statusBoardDAO.save(statusBoard);
	}

	@Override
	public boolean update(StatusBoard statusBoard) throws Exception {
		return statusBoardDAO.update(statusBoard);
	}

	@Override
	public boolean delete(StatusBoard statusBoard) throws Exception {
		return statusBoardDAO.delete(statusBoard);
	}

	

}
