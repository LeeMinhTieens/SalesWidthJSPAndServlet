package com.leminhtien.model;

public class ProductColorModel extends AbstractModel<ProductColorModel>{
	private Integer productId;
	private Integer colorId;

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getColorId() {
		return colorId;
	}
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}
	
	
}