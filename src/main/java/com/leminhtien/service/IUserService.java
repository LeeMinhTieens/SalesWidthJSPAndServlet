package com.leminhtien.service;

import com.leminhtien.model.UserModel;

public interface IUserService {
	UserModel save(UserModel userModel);
	void update(UserModel userModel);
	void delete(UserModel userModel);
	UserModel fineByUserNameAndPassWord(String userName, String password);
	UserModel fineBySocialId(String social_id);
}