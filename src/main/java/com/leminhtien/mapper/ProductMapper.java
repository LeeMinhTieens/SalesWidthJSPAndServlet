package com.leminhtien.mapper;

import java.sql.ResultSet;

import com.leminhtien.model.ProductModel;

public class ProductMapper implements RowMapper<ProductModel>{
	@Override
	public ProductModel add(ResultSet resultSet) {
		ProductModel productModel = new ProductModel();
		try {
			productModel.setId(resultSet.getInt("id"));
			productModel.setName(resultSet.getString("name"));
			productModel.setPrize(resultSet.getFloat("prize"));
			productModel.setShortDescription(resultSet.getString("shortdescription"));
			productModel.setQuantity(resultSet.getInt("quantity"));
			productModel.setContent(resultSet.getString("content"));
			productModel.setSellNumber(resultSet.getInt("sellnumber"));
			productModel.setTypeId(resultSet.getInt("type_id"));
			productModel.setImg(resultSet.getString("img"));
			return productModel;
		} catch (Exception e) {
			return null;
		}
		
	}

}
