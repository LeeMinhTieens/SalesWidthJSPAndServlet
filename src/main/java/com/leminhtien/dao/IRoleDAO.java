package com.leminhtien.dao;

import com.leminhtien.model.RoleModel;

public interface IRoleDAO extends GenericDAO<RoleModel>{
	RoleModel fineById(Integer id);
}
