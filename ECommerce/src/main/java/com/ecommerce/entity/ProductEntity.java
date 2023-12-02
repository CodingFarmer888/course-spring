package com.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

	/** 商品鍵值 */
	@Id
	@Column(name = "PRODUCT_KEY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productKey;
	
	/** 商品ID */
	@Column(name = "PRODUCT_ID")
	private String productId;
	
	/** 商品名稱 */
	@Column(name = "NAME")
	private String name;
	
	/** 品牌 */
	@Column(name = "BRAND")
	private String brand;
	
	/** 商品狀態(上下架) */
	@Column(name = "STATUS")
	private Integer status;
	
	@JsonIgnore
    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductPriceEntity productPriceEntity;

	public Long getProductKey() {
		return productKey;
	}

	public void setProductKey(Long productKey) {
		this.productKey = productKey;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ProductPriceEntity getProductPriceEntity() {
		return productPriceEntity;
	}

	public void setProductPriceEntity(ProductPriceEntity productPriceEntity) {
		this.productPriceEntity = productPriceEntity;
	}
	
}
