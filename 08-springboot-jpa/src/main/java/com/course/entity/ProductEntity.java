package com.course.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 產品資料表
 */
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

	/** 商品鍵值 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	/** 編碼 */
	@Column(name = "CODE", length = 20, nullable = false)
	private String code;
	
	/** 名稱 */
	@Column(name = "NAME", length = 255, nullable = false)
	private String name;
	
	/** 金額 */
	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;
	
	/** 產生日期 */
	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;
	
	/** 圖片連結 */
	@Column(name = "IMAGE_URL", nullable = true)
	private String imageUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
