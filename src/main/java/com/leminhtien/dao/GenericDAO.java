package com.leminhtien.dao;

import java.util.List;

import com.leminhtien.mapper.RowMapper;

public interface GenericDAO <T>{
	<T> List <T> query(String sql, RowMapper<T> mapper, Object...parameters);
	<T> T fineOne (String query,Object...parametors);
	Integer insert(String sql, Object...parametors);
	void update(String sql, Object...parametors);
	void delete(String sql, Object...paraObjects);

}
