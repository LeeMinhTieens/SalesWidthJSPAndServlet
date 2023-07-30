package com.leminhtien.mapper;

import java.sql.ResultSet;

import com.leminhtien.model.SizeModel;

public class SizeMapper implements RowMapper<SizeModel>{

	@Override
	public SizeModel add(ResultSet resultSet) {
		try {
			SizeModel size = new SizeModel();
			size.setId(resultSet.getInt("id"));
			size.setName(resultSet.getString("name"));
			return size;
		} catch (Exception e) {
			return null;
		}
	}

}
