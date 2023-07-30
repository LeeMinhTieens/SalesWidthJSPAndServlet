package com.leminhtien.service.impl;

import javax.inject.Inject;

import com.leminhtien.dao.IProductSizeDAO;
import com.leminhtien.model.ProductSizeModel;
import com.leminhtien.service.IProductSizeService;

public class ProductSizeService implements IProductSizeService{
	
	@Inject
	private IProductSizeDAO productSizeDAO;

	@Override
	public Integer save(ProductSizeModel productSize) {
		return productSizeDAO.save(productSize);
	}

	@Override
	public Integer update(ProductSizeModel productSize) {
		return productSizeDAO.update(productSize);
	}

	@Override
	public Integer delete(ProductSizeModel productSize) {
		return  productSizeDAO.delete(productSize);
	}

	@Override
	public Integer deleteByProductId(Integer id) {
		return productSizeDAO.deleteByProductId(id);
	}

}
