package com.course.dto;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
	name = "SearchBookMapping", 
	classes = @ConstructorResult(
		targetClass = com.course.dto.BookDto.class, 
		columns = {
			@ColumnResult(name = "ID", type = Long.class), 
			@ColumnResult(name = "BOOKNAME", type = String.class),
			@ColumnResult(name = "AUTHOR", type = String.class),
			@ColumnResult(name = "PRICE", type = Integer.class),
			@ColumnResult(name = "DESCRIPT", type = String.class),
			@ColumnResult(name = "LIBRARYCODE", type = String.class),
			@ColumnResult(name = "LIBRARYNAME", type = String.class) 
		}
	) 
)
@Entity
public class BookDto {

	@Id
	private Long id;

	private String bookName;

	private String author;

	private Integer price;

	private String descript;

	private String libraryCode;

	private String libraryName;

	public BookDto(Long id, String bookName, String author, Integer price, String descript, String libraryCode,
			String libraryName) {
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.descript = descript;
		this.libraryCode = libraryCode;
		this.libraryName = libraryName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
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

	public String getLibraryCode() {
		return libraryCode;
	}

	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

}
