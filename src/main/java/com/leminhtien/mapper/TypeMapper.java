package com.leminhtien.mapper;

import java.sql.ResultSet;

import com.leminhtien.model.TypeModel;

public class TypeMapper implements RowMapper<TypeModel>{

	@Override
	public TypeModel add(ResultSet resultSet) {
		TypeModel typeModel = null;
		try {
			typeModel = new TypeModel();
			typeModel.setId(resultSet.getInt("id"));
			typeModel.setName(resultSet.getString("name"));
			return typeModel;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
