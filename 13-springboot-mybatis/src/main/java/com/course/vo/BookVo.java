package com.course.vo;

public class BookVo {
	
	/** 鍵值 */
	private Long id;

	/** 書名 */
	private String name;
	
	/** 作者 */
	private String author;
	
	/** 價格*/
	private Integer price;
	
	/** 描述 */
	private String descript;
	
	/** 圖書館名稱 */
	private String libraryName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

}
