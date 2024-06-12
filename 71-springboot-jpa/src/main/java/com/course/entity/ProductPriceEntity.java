package com.course.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPriceEntity {

	/** 價格表鍵值 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	/** 產品鍵值 */
	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;
	
	/** 定價 */
	@Column(name = "LIST_PRICE")
	private BigDecimal listPrice;
	
	/** 特價 */
	@Column(name = "SALES_PRICE")
	private BigDecimal salesPrice;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID", insertable=false, updatable=false)
	private ProductEntity product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

//	public ProductEntity getProduct() {
//		return product;
//	}
//
//	public void setProduct(ProductEntity product) {
//		this.product = product;
//	}

}
