package com.leminhtien.dao;

import java.util.ArrayList;
import java.util.List;

import com.leminhtien.model.TypeModel;

public interface ITypeDAO extends  GenericDAO<TypeModel>{
	Integer save(TypeModel typeModel);
	Integer update(TypeModel typeModel);
	Integer delete(Integer id);
	List<TypeModel> fineAll();
	ArrayList<Integer> fineSizeOfProduct(Integer id);
}
