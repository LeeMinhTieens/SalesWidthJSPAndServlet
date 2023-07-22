package com.leminhtien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.leminhtien.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel>{

	@Override
	public RoleModel add(ResultSet resultSet) {
		RoleModel role = new RoleModel();
		try {
			role.setId(resultSet.getInt("id"));
			role.setName(resultSet.getString("name"));
			role.setCode(resultSet.getString("code"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	return role;
	}

}
