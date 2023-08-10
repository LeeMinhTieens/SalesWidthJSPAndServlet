package com.leminhtien.dao.impl;

import java.util.List;

import com.leminhtien.dao.ICartDAO;
import com.leminhtien.model.CartModel;

public class CartDAO extends AbstractDAO<CartModel> implements ICartDAO{

	@Override
	public List<CartModel> fineByProductId(Integer id) {
		
		return null;
	}

}