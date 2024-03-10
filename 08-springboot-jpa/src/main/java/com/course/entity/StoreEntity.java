package com.course.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 門店資料表
 */
@Entity
@Table(name = "STORE")
public class StoreEntity {

	/** 門店鍵值 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** 門店編號 */
	@Column(name = "STORE_CODE", length = 16, nullable = false)
	private String storeCode;

	/** 門店名稱 */
	@Column(name = "STORE_NAME", length = 50, nullable = false)
	private String storeName;

	/** 一對多 關聯 */
	@OneToMany(mappedBy = "store", cascade = { CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<InventoryEntity> inventories = new HashSet<InventoryEntity>();

//	@ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(name = "INVENTORY", joinColumns = @JoinColumn(name = "STORE_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
//	private List<ProductEntity> products = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Set<InventoryEntity> getInventories() {
		return inventories;
	}

	public void setInventories(Set<InventoryEntity> inventories) {
		this.inventories = inventories;
	}

//	public List<ProductEntity> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<ProductEntity> products) {
//		this.products = products;
//	}

}
