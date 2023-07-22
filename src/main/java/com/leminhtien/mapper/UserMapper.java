package com.leminhtien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.leminhtien.model.UserModel;


public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel add(ResultSet resultSet) {
		UserModel user = new UserModel();
		try {
			user.setId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setPassword(resultSet.getString("password"));
			user.setFullname(resultSet.getString("fullname"));
			user.setPhonenumber(resultSet.getString("phonenumber"));
			user.setEmail(resultSet.getString("email"));
			user.setRoleid(resultSet.getInt("role_id"));
			user.setAddress(resultSet.getString("address"));
			user.setCreatedate(resultSet.getTimestamp("createdate"));
			user.setModifyby(resultSet.getString("modifyby"));
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return user;
	}

	

}
