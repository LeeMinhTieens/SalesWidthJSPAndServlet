package com.leminhtien.dao.impl;

import java.util.List;

import com.leminhtien.dao.ISizeDAO;
import com.leminhtien.mapper.SizeMapper;
import com.leminhtien.model.SizeModel;

public class SizeDAO extends AbstractDAO<SizeModel> implements ISizeDAO{

	@Override
	public Integer save(SizeModel size) {
		String sql = "INSERT INTO size(name) VALUES(?)";
		return insert(sql, size.getName());
	}

	@Override
	public Integer update(SizeModel size) {
		String sql = "UPDATE size SET name=? WHERE id = ?";
		return updateOrDelete(sql, size.getName(),size.getId());
	}

	@Override
	public Integer delete(Integer id) {
		String sql = "DELETE FROM size WHERE id = ?";
		return updateOrDelete(sql, id);
	}

	@Override
	public List<SizeModel> fineAll() {
		String sql = "SELECT * FROM size";
		return query(sql, new SizeMapper());
	}

	
}