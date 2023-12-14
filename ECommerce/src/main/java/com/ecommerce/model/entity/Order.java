package com.ecommerce.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_ITEM")
public class Order {

	/** 訂單鍵值 */
	@Id
	@Column(name = "ORDER_KEY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderKey;
	
	/** 顧客鍵值(外鍵) */
	@Column(name = "CUSTOMER_KEY")
	private Long customerKey;
	
	/** 訂單總金額 */
	@Column(name = "TOTAL_AMOUNT")
	private BigDecimal totalAmount;
	
	/** 訂單時間 */
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	/** 
	 * 顧客 <--> 訂單 多對一 關聯
	 * 一位客戶會有多個訂單
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_KEY", insertable = false, updatable = false)
	private Customer customer;

	/**
	 * 商品 多對多 關聯
	 * 如果中間表只有兩張表的外鍵，可以使用ManyToMany
	 * 但是如果中間表還有除了外鍵其他欄位，還是使用OneToMany
	 * 在save的過程中，無論如何設定，都會觸發OrderProduct的Insert，額外產生多餘資料
	 */
	
//    @ManyToMany(cascade = {CascadeType.MERGE})
//    @JoinTable(
//        name = "ORDER_PRODUCT", // 中繼表的名稱，中繼表可以不用設定Entity
//        joinColumns = @JoinColumn(name = "ORDER_KEY"), // 指定Order在中繼表的外鍵
//        inverseJoinColumns = @JoinColumn(name = "PRODUCT_KEY") // 指定Product在中繼表的外鍵
//    )
//    private List<Product> products = new ArrayList<>();
	
	/**
	 * 針對中間表 OrderProduct 一對多 關聯
	 */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderProducts = new ArrayList<>();


	public Long getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(Long orderKey) {
		this.orderKey = orderKey;
	}

	public Long getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(Long customerKey) {
		this.customerKey = customerKey;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
