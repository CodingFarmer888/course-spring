package com.ecommerce.model.vo;

public class Pagination {

	/** 每頁幾個物件 */
	private Integer pageSize;
	
	/** 當前頁碼 */
	private Integer currentPage;
	
	/** 總共幾頁 */
	private Integer pageCount;
	
	/** 關鍵字 */
	private String searchKeyword;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
}
