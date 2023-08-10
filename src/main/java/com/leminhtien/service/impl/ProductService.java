package com.leminhtien.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.leminhtien.dao.IProductDAO;
import com.leminhtien.model.ProductModel;
import com.leminhtien.model.ProductSizeModel;
import com.leminhtien.paging.Paging;
import com.leminhtien.service.IProductService;
import com.leminhtien.service.IProductSizeService;
import com.leminhtien.service.ITypeService;

public class ProductService implements IProductService{
	
	@Inject
	private IProductDAO productDAO;
	
	@Inject
	private IProductSizeService productSize;
	
	@Inject
	private ITypeService typeService;

	@Override
	public List<ProductModel> fineAll(Paging pagable) {
		
		List<ProductModel> list =  productDAO.fineAll(pagable);
		try {
			for(ProductModel product : list) {
				product.setProductSize(typeService.fineIds(product.getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public List<ProductModel> fineByName(String name) {
		List<ProductModel> list =  productDAO.fineByName(name);
		try {
			for(ProductModel product : list) {
				product.setProductSize(typeService.fineIds(product.getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	
	public ProductModel fineById(Integer id) {		
		ProductModel product =  productDAO.fineById(id);
		try {
			product.setProductSize(typeService.fineIds(product.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return product;
	}

	@Override
	public Integer save(ProductModel productModel) {
		productModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
		productModel.setPrize(0f);
		productModel.setSellNumber(0);
		Integer ids[] = productModel.getProductSize();
		Integer productId = productDAO.save(productModel);
		try {		
			for(Integer id : ids) {
				ProductSizeModel size = new  ProductSizeModel();
				size.setProductId(productId);
				size.setSizeId(id);
				productSize.save(size);
			}
		}catch (Exception e) {
			return null;
		}
		return productId;
	}

	@Override
	public Integer update(ProductModel productModel) {
		try {
			productSize.deleteByProductId(productModel.getId());
			Integer ids[] = productModel.getProductSize();
			for(Integer id : ids) {
				ProductSizeModel size = new  ProductSizeModel();
				size.setProductId(productModel.getId());
				size.setSizeId(id);
				productSize.save(size);
			}
			productModel.setModifyDate(new Timestamp(System.currentTimeMillis()));
			return productDAO.update(productModel);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Integer delete(ProductModel productModel) {
		return productDAO.delete(productModel);
	}
	

	
	public Integer delete(Integer[]ids) {
		Integer result = 0;
		try {
			for(Integer id : ids) {
				result += this.delete(id);
			}
			return result;
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Integer countItem() {
		return productDAO.countItem();
	}
	
	
	
	private Integer delete(Integer id) {
		try {
			productSize.deleteByProductId(id);
			return productDAO.delete(id);
		} catch (Exception e) {
			return null;
		}
		
	}
	
}