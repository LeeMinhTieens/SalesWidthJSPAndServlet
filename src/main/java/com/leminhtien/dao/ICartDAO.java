package com.leminhtien.dao;

import java.util.List;

import com.leminhtien.model.CartModel;

public interface ICartDAO extends GenericDAO<CartModel>{
	List<CartModel> fineByProductId(Integer id); 
}
