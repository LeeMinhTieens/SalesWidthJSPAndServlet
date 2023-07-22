package com.leminhtien.service.impl;

import java.sql.Timestamp;

import javax.inject.Inject;

import com.leminhtien.dao.IUserDAO;
import com.leminhtien.model.UserModel;
import com.leminhtien.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO userDao;

	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreatedate(new Timestamp(System.currentTimeMillis()));
		userModel.setRoleid(2);
		Integer id =  userDao.save(userModel);
		return userDao.fineOne(id);
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
		
		return userDao.fineByUserNameAndPassWord(userName, password);
	}

	

}
