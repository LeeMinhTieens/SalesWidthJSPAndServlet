package com.leminhtien.dao.impl;

import java.util.List;

import com.leminhtien.dao.IProductDAO;
import com.leminhtien.mapper.ProductMapper;
import com.leminhtien.model.ProductModel;
import com.leminhtien.paging.Paging;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO{

	@Override
	public List<ProductModel> fineAll(Paging pagable) {
//		String sql ="SELECT id,name,prize,shortdescription,quantity,content,sellnumber FROM product";
		StringBuilder sql = new StringBuilder("SELECT * FROM product");
		if(pagable != null) {
			if(pagable.getSort() != null) {
				sql.append(" ORDER BY ");
				sql.append(pagable.getSort().getSortName());
				sql.append(" ");
				sql.append(pagable.getSort().getSortBy());
			}
			sql.append(" LIMIT "+ pagable.getPage() +","+pagable.getLimit());
			
		}
		return query(sql.toString(),new ProductMapper());
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
		String sql = "INSERT INTO product (name,prize,shortdescription,quantity,createBy,createdate,content,sellnumber,type_id,img) VALUES (?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, productModel.getName(),productModel.getPrize(),productModel.getShortDescription(),productModel.getQuantity(),
				productModel.getCreateBy(),productModel.getCreateDate(),productModel.getContent(),productModel.getSellNumber(),productModel.getTypeId(),productModel.getImg());
	}

	@Override
	public Integer update(ProductModel productMode) {
		String sql = "UPDATE product SET name=?,shortdescription= ?,quantity= ?,content= ?,modifydate= ?,modifyby= ?,type_id = ?,img=?  WHERE id = ?";
		return updateOrDelete(sql,productMode.getName(),productMode.getShortDescription(),productMode.getQuantity(),
				productMode.getContent(),productMode.getModifyDate(),productMode.getModifyBy(),productMode.getTypeId(),productMode.getImg(),productMode.getId());
	}

	@Override
	public Integer delete(ProductModel productModel) {
		String sql = "DELETE FROM product WHERE id = ?";
		return updateOrDelete(sql, productModel.getId());
	}
	
	@Override
	public Integer delete(Integer id) {
		String sql = "DELETE FROM product WHERE id = ?";
		return updateOrDelete(sql, id);
	}

	@Override
	public Integer countItem() {
		String sql = "SELECT COUNT(*) FROM product";
		return count(sql);
	}
	

}
