package com.ecommerce.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 訂單-商品 中繼表
 */
@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct {

	/** 訂單商品鍵值 */
	@Id
	@Column(name = "ORDER_PRODUCT_KEY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderProductKey;
	
    @ManyToOne
    @JoinColumn(name = "ORDER_KEY")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_KEY")
    private Product product;
    
    /** 商品數量 */
    // 為了要加入此欄位，才多產生這張表的Entity，如果中繼表只有單純的關聯，不需要額外建立Entity
    @Column(name = "PRODUCT_QTY")
    private Integer qty;

	public Long getOrderProductKey() {
		return orderProductKey;
	}

	public void setOrderProductKey(Long orderProductKey) {
		this.orderProductKey = orderProductKey;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
