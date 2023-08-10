package com.leminhtien.dao;

import java.util.List;

import com.leminhtien.model.SizeModel;

public interface ISizeDAO extends GenericDAO<SizeModel>{
	Integer save(SizeModel size);
	Integer update(SizeModel size);
	Integer delete(Integer id);
	List<SizeModel> fineAll();
}