package com.leminhtien.service;

import java.util.List;

import com.leminhtien.model.ProductModel;
import com.leminhtien.paging.Paging;

public interface IProductService {
	List<ProductModel> fineAll(Paging pagable);
	List<ProductModel> fineByName(String name);
	ProductModel fineById(Integer id);
	Integer save(ProductModel productModel);
	Integer update(ProductModel productMode);
	Integer delete(ProductModel productModel);
	Integer delete(Integer id);
	Integer countItem();
}
