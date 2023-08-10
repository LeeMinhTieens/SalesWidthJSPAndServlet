package com.leminhtien.service.impl;

import java.sql.Timestamp;

import javax.inject.Inject;

import com.leminhtien.dao.IUserDAO;
import com.leminhtien.model.RoleModel;
import com.leminhtien.model.UserModel;
import com.leminhtien.service.IRoleService;
import com.leminhtien.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO userDao;

	@Inject
	private IRoleService roleService;
	
	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreatedate(new Timestamp(System.currentTimeMillis()));
		userModel.setRoleid(2);
		if(userModel.getSocial_id() == null) {
			userModel.setSocial_id("");
		}else {
			userModel.setPassword(userModel.getSocial_id());
		}
		Integer id =  userDao.save(userModel);
		UserModel user =  userDao.fineOne(id);
		
		if(user != null) {
			try {
				RoleModel role = roleService.fineById(user.getRoleid());
				user.setCode(role.getCode());
			} catch (Exception e) {
				userDao.delete(user);
				return null;
			}
		}
		return user;
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
		UserModel user =  userDao.fineByUserNameAndPassWord(userName, password);
		
		return user;
	}

	@Override
	public UserModel fineBySocialId(String social_id) {
		UserModel user =  userDao.fineBySocailId(social_id);
		if(user != null) {
			try {
				RoleModel role = roleService.fineById(user.getRoleid());
				user.setCode(role.getCode());
			} catch (Exception e) {
				userDao.delete(user);
				return null;
			}
		}
		return user;
	}

	

}