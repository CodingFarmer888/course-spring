package com.ecommerce.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

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
	
    @Lob
    @Column(name = "IMG_DATA")
    private byte[] imageData;
	
	/** 
	 * 如果這個欄位往轉成JSON往前端傳，會因為雙向關聯在序列化的過程，造成無窮回圈，需要加入JsonIgnore
	 * 但是實務上不會把Entity直接往前端傳，都會在包一層DTO
	 */
	// @JsonIgnore
	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductPrice productPrice;
	
    @ManyToMany(mappedBy = "products", cascade = {CascadeType.MERGE})
    private List<Order> orders;

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

	public ProductPrice getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(ProductPrice productPrice) {
		this.productPrice = productPrice;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
