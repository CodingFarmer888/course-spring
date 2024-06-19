package com.course.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "book_detail")
public class BookDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer price;
	
	private String descript;
	
	// 在資料表的結構當中，有參照於 BOOK.ID 的 BOOK_ID 的外鍵欄位，
	// 這裡使用關聯物件 Book 來進行管理，所以移除bookId欄位
	// @Column(name = "book_id")
	// private Long bookId;
	
    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

}
