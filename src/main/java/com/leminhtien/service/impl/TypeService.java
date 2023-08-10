package com.leminhtien.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.leminhtien.dao.ITypeDAO;
import com.leminhtien.model.TypeModel;
import com.leminhtien.service.ITypeService;

public class TypeService  implements ITypeService{
	
	@Inject
	private ITypeDAO typeDAO;

	@Override
	public Integer save(TypeModel typeModel) {
		return typeDAO.save(typeModel);
	}

	@Override
	public Integer update(TypeModel typeModel) {
		return typeDAO.update(typeModel);
	}

	@Override
	public Integer delete(Integer id) {
		return typeDAO.delete(id);
	}

	@Override
	public List<TypeModel> fineAll() {
		return typeDAO.fineAll();
	}

	@Override
	public Integer[] fineIds(Integer id) {
		ArrayList<Integer> list= typeDAO.fineSizeOfProduct(id);
		Integer[] ids = new Integer[list.size()];
		for(int i=0;i<list.size();i++) {
			ids[i] = list.get(i);
		}
		return ids;
	}
	

}