package com.leminhtien.service.impl;

import javax.inject.Inject;

import com.leminhtien.dao.IRoleDAO;
import com.leminhtien.model.RoleModel;
import com.leminhtien.service.IRoleService;

public class RoleService implements IRoleService{
	
	@Inject
	private IRoleDAO roleDAO;

	@Override
	public RoleModel fineById(Integer id) {
		return roleDAO.fineById(id);
	}

}