package com.leminhtien.dao.impl;

import com.leminhtien.dao.IRoleDAO;
import com.leminhtien.mapper.RoleMapper;
import com.leminhtien.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO{

	@Override
	public RoleModel fineById(Integer id) {
		String sql = "SELECT * FROM role WHERE id = ?";
		return fineOne(sql, new RoleMapper(), id);
	}

}
