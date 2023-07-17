package com.leminhtien.dao.impl;

import java.util.List;

import com.leminhtien.dao.GenericDAO;
import com.leminhtien.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T>{

	@Override
	public <T> List<T> query(String sql, RowMapper<T> mapper, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T fineOne(String query, Object... parametors) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(String sql, Object... parametors) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String sql, Object... parametors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String sql, Object... paraObjects) {
		// TODO Auto-generated method stub
		
	}

}
