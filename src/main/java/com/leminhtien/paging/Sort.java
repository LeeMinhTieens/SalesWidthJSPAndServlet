package com.leminhtien.paging;

public class Sort {
	private String sortName;//sắp xếp theo tên
	private String sortBy;//ASC or DESC
	
	public Sort() {
		
	}
	
	public Sort(String sortName, String sortBy) {
		this.sortName = sortName;
		this.sortBy = sortBy;
	}
	
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
}
