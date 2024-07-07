package com.course.vo;

public class BookVo {

	/** 鍵值 */
	private Long id;
	
	/** 書名 */
	private String name;
	
	/** 作者 */
	private String author;
	
	/** 擁有人 */
	private String owner;

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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
