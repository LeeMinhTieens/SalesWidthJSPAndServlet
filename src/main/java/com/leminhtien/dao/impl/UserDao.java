package com.leminhtien.dao.impl;

import javax.inject.Inject;

import com.leminhtien.dao.IUserDAO;
import com.leminhtien.mapper.UserMapper;
import com.leminhtien.model.UserModel;
import com.leminhtien.service.IRoleService;

public class UserDao extends AbstractDAO<UserModel> implements IUserDAO{
	@Inject
	private IRoleService roleService;
	
	@Override
	public Integer save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO user (name, password," );
		sql.append("fullname,phonenumber,address,email,role_id,createdate,social_id)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
		return insert(sql.toString(),userModel.getName(),userModel.getPassword(),userModel.getFullname(),userModel.getPhonenumber(),userModel.getAddress(),userModel.getEmail(),userModel.getRoleid(),userModel.getCreatedate(),userModel.getSocial_id());
	}

	@Override
	public Integer update(UserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(UserModel userModel) {
		String sql = "DELETE FROM user WHERE id=?";
		return updateOrDelete(sql, userModel.getId());
	}

	@Override
	public UserModel fineByUserNameAndPassWord(String userName, String password) {
		String sql = "SELECT * FROM user WHERE name = ? AND password = ?";
		 return  fineOne(sql, new UserMapper(), userName, password);
	}

	@Override
	public UserModel fineOne(Integer id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		return fineOne(sql,new UserMapper(), id);
	}

	@Override
	public UserModel fineBySocailId(String socialId) {
		String sql = "SELECT * FROM user WHERE social_id = ?";
		return fineOne(sql, new UserMapper(),socialId);
	}

	


}