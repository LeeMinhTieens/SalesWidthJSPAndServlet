package com.leminhtien.model;

public class ProductGenderTypeModel extends AbstractModel<ProductGenderTypeModel>{
	private Integer productId;
	private Integer typeId;
	

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
}