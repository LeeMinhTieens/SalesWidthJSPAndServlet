package com.leminhtien.service;

import java.util.List;

import com.leminhtien.model.SizeModel;

public interface ISizeService {
	Integer save(SizeModel sizeModel);
	Integer update(SizeModel sizeModel);
	Integer delete(Integer id);
	List<SizeModel> fineAll();
}