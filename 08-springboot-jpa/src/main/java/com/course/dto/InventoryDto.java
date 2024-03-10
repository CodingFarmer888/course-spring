package com.course.dto;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "InventoryCustomDtoMapping", classes = {
		@ConstructorResult(targetClass = com.course.dto.InventoryDto.class, columns = {
				@ColumnResult(name = "ID", type = Long.class),
				@ColumnResult(name = "PRODUCTNAME", type = String.class),
				@ColumnResult(name = "STORENAME", type = String.class),
				@ColumnResult(name = "QUANTITY", type = Integer.class) }) })
@Entity
public class InventoryDto {

	@Id
	private Long id;
	
	/** 商品名稱 */
	private String productName;

	/** 門店名稱 */
	private String storeName;

	/** 數量 */
	private Integer quantity;

	public InventoryDto() {

	}

	public InventoryDto(Long id, String productName, String storeName, Integer quantity) {
		this.id = id;
		this.productName = productName;
		this.storeName = storeName;
		this.quantity = quantity;
	}

	public InventoryDto(String productName, String storeName, Integer quantity) {
		this.productName = productName;
		this.storeName = storeName;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
