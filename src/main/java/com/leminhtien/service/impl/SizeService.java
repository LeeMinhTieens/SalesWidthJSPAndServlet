package com.leminhtien.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.leminhtien.dao.ISizeDAO;
import com.leminhtien.model.SizeModel;
import com.leminhtien.service.ISizeService;

public class SizeService implements ISizeService{

	@Inject
	private ISizeDAO sizeDAO;
	
	@Override
	public Integer save(SizeModel sizeModel) {
		return sizeDAO.save(sizeModel);
	}

	@Override
	public Integer update(SizeModel sizeModel) {
		
		return sizeDAO.update(sizeModel);
	}

	@Override
	public Integer delete(Integer id) {
		
		return sizeDAO.delete(id);
	}

	@Override
	public List<SizeModel> fineAll() {	
		return sizeDAO.fineAll();
	}

}