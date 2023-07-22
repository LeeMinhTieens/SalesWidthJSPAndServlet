package com.leminhtien.dao.impl;

import java.util.List;

import com.leminhtien.dao.IProductDAO;
import com.leminhtien.mapper.ProductMapper;
import com.leminhtien.model.ProductModel;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO{

	@Override
	public List<ProductModel> fineAll() {
//		String sql ="SELECT id,name,prize,shortdescription,quantity,content,sellnumber FROM product";
		String sql = "SELECT * FROM product";
		return query(sql,new ProductMapper());
	}

	@Override
	public List<ProductModel> fineByName(String name) {
		String sql = "SELECT * FROM product WHERE name LIKE ?";
		return query(sql,new ProductMapper(),"%"+name+"%");
	}

	@Override
	public ProductModel fineById(Integer id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		return fineOne(sql, new ProductMapper(), id);
	}

	@Override
	public Integer save(ProductModel productModel) {
		String sql = "INSERT INTO product (name,prize,shortdescription,quantity,createBy,createdate,content,sellnumber) VALUES (?,?,?,?,?,?,?,?)";
		return insert(sql, productModel.getName(),productModel.getPrize(),productModel.getShortDescription(),productModel.getQuantity(),
				productModel.getCreateBy(),productModel.getCreateDate(),productModel.getContent(),productModel.getSellNumber());
	}

	@Override
	public Integer update(ProductModel productMode) {
		String sql = "UPDATE product SET name=? ,prize= ?,shortdescription= ?,quantity= ?,content= ?,sellnumber= ?,modifydate= ?,modifyby= ? WHERE id = ?";
		return updateOrDelete(sql,new ProductMapper(),productMode.getName(),productMode.getPrize(),productMode.getShortDescription(),productMode.getQuantity(),
				productMode.getContent(),productMode.getSellNumber(),productMode.getModifyDate(),productMode.getModifyBy(),productMode.getId());
	}

	@Override
	public Integer delete(ProductModel productModel) {
		String sql = "DELETE FROM product WHERE id = ?";
		return updateOrDelete(sql, productModel.getId());
	}
	
	public Integer delete(Integer id) {
		String sql = "DELETE FROM product WHERE id = ?";
		return updateOrDelete(sql, id);
	}
	
	public Integer delete(Integer[]ids) {
		Integer result = 0;
		try {
			for(Integer id : ids) {
				result += delete(id);
			}
			return result;
			
		} catch (Exception e) {
			return null;
		}
	}

}
