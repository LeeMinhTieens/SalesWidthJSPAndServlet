package com.leminhtien.model;

import java.sql.Timestamp;

public class ProductModel extends AbstractModel<ProductModel>{
	private String name;
	private Float prize;
	private String shortDescription;
	private Integer quantity;
	private String createBy;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private String modifyBy;
	private String content;
	private Integer sellNumber;
	private Integer typeId;
	private String img;
	private Integer[] productSize;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrize() {
		return prize;
	}
	public void setPrize(Float prize) {
		this.prize = prize;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getSellNumber() {
		return sellNumber;
	}
	public void setSellNumber(Integer sellNumber) {
		this.sellNumber = sellNumber;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer[] getProductSize() {
		return productSize;
	}
	public void setProductSize(Integer[] productSize) {
		this.productSize = productSize;
	}
	
	private String getx(Integer[] productSize) {
		if(productSize != null) {
			String text = "\nmang là: ";
			for(Integer x:productSize ) {
				text+=x.toString()+"\n";
			}
			return text;
		}else {
			return "mang null";
		}
	}
	
	@Override
	public String toString() {
		return 	this.getId()+"\n"+
				this.getName()+"\n"+
				this.getContent()+"\n"+
				this.getCreateBy()+"\n"+
				this.getImg()+"\n"+
				this.getModifyBy()+"\n"+
				this.getShortDescription()+"\n"+
				this.getPrize()+"\n"+
				this.getSellNumber()+"\n"+
				this.getQuantity()+"\n"+
				this.getCreateDate()+"\n"+
				this.getTypeId()+"\n"+
				getx(this.getProductSize());
				
				
	}
}