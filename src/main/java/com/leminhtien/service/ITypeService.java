package com.leminhtien.service;

import java.util.List;

import com.leminhtien.model.TypeModel;

public interface ITypeService{
	Integer save(TypeModel typeModel);
	Integer update(TypeModel typeModel);
	Integer delete(Integer id);
	List<TypeModel> fineAll();
	Integer[] fineIds(Integer id);
}
