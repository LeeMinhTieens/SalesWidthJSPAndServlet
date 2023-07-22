package com.leminhtien.mapper;

import java.sql.ResultSet;

public interface RowMapper <T>{
	 T add( ResultSet resultSet);
}
