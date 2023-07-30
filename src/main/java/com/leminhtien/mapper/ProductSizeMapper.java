package com.leminhtien.mapper;

import java.sql.ResultSet;

import com.leminhtien.model.ProductSizeModel;

public class ProductSizeMapper implements RowMapper<ProductSizeModel> {

	@Override
	public ProductSizeModel add(ResultSet resultSet) {
		ProductSizeModel productSize = null;
		try {
			productSize = new ProductSizeModel();
			productSize.setId(resultSet.getInt("id"));
			productSize.setProductId(resultSet.getInt("product_id"));
			productSize.setSizeId(resultSet.getInt("size_id"));
			return productSize;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
