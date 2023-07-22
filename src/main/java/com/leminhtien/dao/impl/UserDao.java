package com.leminhtien.dao.impl;

import javax.inject.Inject;

import com.leminhtien.dao.IUserDAO;
import com.leminhtien.mapper.UserMapper;
import com.leminhtien.model.RoleModel;
import com.leminhtien.model.UserModel;
import com.leminhtien.service.IRoleService;

public class UserDao extends AbstractDAO<UserModel> implements IUserDAO{
	@Inject
	private IRoleService roleService;
	
	@Override
	public Integer save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO user (name, password," );
		sql.append("fullname,phonenumber,address,email,role_id,createdate)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?)");
		return insert(sql.toString(),userModel.getName(),userModel.getPassword(),userModel.getFullname(),userModel.getPhonenumber(),userModel.getAddress(),userModel.getEmail(),userModel.getRoleid(),userModel.getCreatedate());
	}

	@Override
	public void update(UserModel userModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserModel userModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel fineByUserNameAndPassWord(String userName, String password) {
		String sql = "SELECT * FROM user WHERE name = ? AND password = ?";
		UserModel user =  fineOne(sql, new UserMapper(), userName, password);
		if(user != null) {
			RoleModel role = roleService.fineById(user.getRoleid());
			user.setCode(role.getCode());
		}
		return user;
	}

	@Override
	public UserModel fineOne(Integer id) {
		String sql = "SELECT * FROM user WHERE id = ?;";
		return fineOne(sql,new UserMapper(), id);
	}

	


}
