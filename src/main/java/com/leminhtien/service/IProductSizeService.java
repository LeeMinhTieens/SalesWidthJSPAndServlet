package com.leminhtien.service;

import com.leminhtien.model.ProductSizeModel;

public interface IProductSizeService {
	Integer save(ProductSizeModel productSize);
	Integer update(ProductSizeModel productSize);
	Integer delete(ProductSizeModel productSize);
	Integer deleteByProductId(Integer id);

}