package com.codingz.quote.iservice;

import java.util.List;




import com.codingz.quote.model.Role;

public interface IRoleService {
	
	public Role findById(Long id)throws Exception;
	public List<Role> findAll()throws Exception;
	public boolean save(Role role)throws Exception;
	public boolean update(Role role)throws Exception;
	public boolean delete(Role role)throws Exception;

}
