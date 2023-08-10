package com.leminhtien.dao;

import com.leminhtien.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
		Integer save(UserModel userModel);
		Integer update(UserModel userModel);
		Integer delete(UserModel userModel);
		UserModel fineByUserNameAndPassWord(String userName, String password);
		UserModel fineOne(Integer id);
		UserModel fineBySocailId(String socialId);
}