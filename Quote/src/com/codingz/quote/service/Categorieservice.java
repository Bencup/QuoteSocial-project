package com.codingz.quote.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.quote.idao.ICategoriesDAO;
import com.codingz.quote.iservice.ICategoriesService;
import com.codingz.quote.model.Categories;

@Service
@Transactional
public class Categorieservice implements ICategoriesService {
	
	@Autowired
	private ICategoriesDAO categoriesDAO;

	@Override
	public Categories findById(Long id) throws Exception {
		return categoriesDAO.findById(id);
	}

	@Override
	public List<Categories> findAll() throws Exception {
		return categoriesDAO.findAll();
	}

	@Override
	public boolean save(Categories categories) throws Exception {
		return categoriesDAO.save(categories);
	}

	@Override
	public boolean update(Categories categories) throws Exception {
		return categoriesDAO.update(categories);
	}

	@Override
	public boolean delete(Categories categories) throws Exception {
		return categoriesDAO.delete(categories);
	}

	

}
