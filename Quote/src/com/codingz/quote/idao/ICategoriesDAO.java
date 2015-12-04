package com.codingz.quote.idao;

import java.util.List;


import com.codingz.quote.model.Categories;

public interface ICategoriesDAO {
	
	public Categories findById(Long id)throws Exception;
	public List<Categories> findAll()throws Exception;
	public boolean save(Categories categories)throws Exception;
	public boolean update(Categories categories)throws Exception;
	public boolean delete(Categories categories)throws Exception;
}
