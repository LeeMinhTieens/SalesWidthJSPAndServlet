package com.leminhtien.dao.impl;


import com.leminhtien.dao.IProductSizeDAO;
import com.leminhtien.model.ProductSizeModel;

public class ProductSizeDAO extends AbstractDAO<ProductSizeModel> implements IProductSizeDAO{

	@Override
	public Integer save(ProductSizeModel productSize) {
		String sql = "INSERT INTO product_size (product_id,size_id) VALUES(?,?)";
		return insert(sql, productSize.getProductId(),productSize.getSizeId());
	}

	@Override
	public Integer update(ProductSizeModel productSize) {
		String sql = "UPDATE product_size SET product_id = ?, size_id = ? WHERE id = ?";
		return updateOrDelete(sql, productSize.getProductId(),productSize.getSizeId(),productSize.getId());
	}

	@Override
	public Integer delete(ProductSizeModel productSize) {
		String sql = "DELETE FROM product_size WHERE id = ?";
		return updateOrDelete(sql, productSize.getId());
	}
	
	@Override
	public Integer deleteByProductId(Integer id) {
		String sql = "DELETE FROM product_size WHERE product_id = ?";
		return updateOrDelete(sql,id);
	}

	

	
}
