package com.course.model;

public class BookVo {
	/** 鍵值 */
	private Integer id;
	
	/** 書名 */
	private String name;
	
	/** 作者 */
	private String author;
	
	/** 圖檔名稱 */
	private String imgName;
	
	public BookVo() {
		
	}

	public BookVo(Integer id, String name, String author, String imgName) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.imgName = imgName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
}
