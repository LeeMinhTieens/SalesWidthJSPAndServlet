package com.leminhtien.dao;

import com.leminhtien.model.ProductSizeModel;

public interface IProductSizeDAO extends GenericDAO<ProductSizeModel>{
	Integer save(ProductSizeModel productSize);
	Integer update(ProductSizeModel productSize);
	Integer delete(ProductSizeModel productSize);
	Integer deleteByProductId(Integer id);
}