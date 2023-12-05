package com.ecommerce.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPrice {

	/** 鍵值 */
	@Id
	@Column(name = "PRODUCT_KEY")
	private Long productKey;
	
	/** 定價 */
	@Column(name = "LIST_PRICE")
	private BigDecimal listPrice;

	/** 售價 */
	@Column(name = "SALES_PRICE")
	private BigDecimal salesPrice;
	
	/** 關聯鍵值 */
    @OneToOne
    @JoinColumn(name = "PRODUCT_KEY", insertable = false)
    private Product product;

	public Long getProductKey() {
		return productKey;
	}

	public void setProductKey(Long productKey) {
		this.productKey = productKey;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
