package com.leminhtien.paging;

public class Paging implements IPaging{
	private Sort sort;
	private int page;//trang đang đứng
	private int limit;//số trang hiển thị
	private int totalPage;
	private int totalItem;
	
	public Paging() {
		this.sort = null;
		this.page = 1;
		this.limit=10;
	}
	
	public Paging(Sort sort) {
		this.sort = sort;
		this.page = 1;
		this.limit=10;
	}
	
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	public int getTotalPage() {
		return (int)Math.ceil((double)this.getTotalItem()/this.getLimit());
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	@Override
	public int getOfset() {
		return (this.getPage() -1)*this.getLimit();
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}
	
	
	

}
