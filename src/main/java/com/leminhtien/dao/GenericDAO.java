package com.leminhtien.dao;

import java.util.List;

import com.leminhtien.mapper.RowMapper;

public interface GenericDAO <T>{
	<T> List <T> query(String sql, RowMapper<T> mapper, Object...parameters);
	<T> T fineOne (String query,RowMapper<T> mapper, Object...parameters);
	Integer insert(String sql, Object...parameters);
	Integer updateOrDelete(String sql, Object...parameters);
	
}