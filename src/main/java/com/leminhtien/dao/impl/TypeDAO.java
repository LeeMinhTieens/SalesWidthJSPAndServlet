package com.leminhtien.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.leminhtien.dao.ITypeDAO;
import com.leminhtien.mapper.TypeMapper;
import com.leminhtien.model.TypeModel;

public class TypeDAO extends AbstractDAO<TypeModel> implements ITypeDAO{

	@Override
	public Integer save(TypeModel typeModel) {
		String sql = "INSERT INTO type (name) VALUES (?)";
		return insert(sql, typeModel.getName());
	}

	@Override
	public Integer update(TypeModel typeModel) {
		String sql = "UPDATE type SET name = ? WHERE id = ?";
		return updateOrDelete(sql, typeModel.getName(),typeModel.getId());
	}

	@Override
	public Integer delete(Integer id) {
		String sql = "DELETE FROM type WHERE id = ?";
		return updateOrDelete(sql,id);
	}
	
	public List<TypeModel> fineAll() {
		String sql = "SELECT * FROM type";
		return query(sql, new TypeMapper());
	}

	@Override
	public ArrayList<Integer> fineSizeOfProduct(Integer id) {
		String sql = "SELECT size_id FROM product_size WHERE product_id = ?";
		return fineIds(sql, "size_id",id);
	}

	
}