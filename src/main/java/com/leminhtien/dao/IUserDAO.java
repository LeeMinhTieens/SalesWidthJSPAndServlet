package com.leminhtien.dao;

import com.leminhtien.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
		Integer save(UserModel userModel);
		void update(UserModel userModel);
		void delete(UserModel userModel);
		UserModel fineByUserNameAndPassWord(String userName, String password);
}
