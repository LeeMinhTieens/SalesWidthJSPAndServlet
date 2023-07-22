package com.leminhtien.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.leminhtien.dao.IProductDAO;
import com.leminhtien.model.ProductModel;
import com.leminhtien.service.IProductService;

public class ProductService implements IProductService{
	
	@Inject
	private IProductDAO productDAO;

	@Override
	public List<ProductModel> fineAll() {
		return productDAO.fineAll();
	}

	@Override
	public List<ProductModel> fineByName(String name) {
		return productDAO.fineByName(name);
	}

	@Override
	public ProductModel fineById(Integer id) {
		return productDAO.fineById(id);
	}

	@Override
	public Integer save(ProductModel productModel) {
		productModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
		return productDAO.save(productModel);
	}

	@Override
	public Integer update(ProductModel productModel) {
		productModel.setModifyDate(new Timestamp(System.currentTimeMillis()));
		return productDAO.update(productModel);
	}

	@Override
	public Integer delete(ProductModel productModel) {
		return productDAO.delete(productModel);
	}

}
