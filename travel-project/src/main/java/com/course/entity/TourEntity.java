package com.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TOUR")
public class TourEntity {
	
	/** 鍵值 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** 標題 */
	@Column
	private String title;
	
	/** 描述 */
	@Column
	private String descript;
	
	/** 圖檔名稱 */
	@Column
	private String imgName;
	
	/** 定價 */
	@Column
	private Integer listPrice;
	
	/** 特價 */
	@Column
	private Integer salesPrice;
	
	/** 是否高光焦點 */
	@Column
	private boolean highLight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public Integer getListPrice() {
		return listPrice;
	}

	public void setListPrice(Integer listPrice) {
		this.listPrice = listPrice;
	}

	public Integer getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Integer salesPrice) {
		this.salesPrice = salesPrice;
	}

	public boolean isHighLight() {
		return highLight;
	}

	public void setHighLight(boolean highLight) {
		this.highLight = highLight;
	}	
}
