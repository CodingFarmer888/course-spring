package com.course.vo;

/**
 * 旅遊Vo物件
 */
public class TourVo {

	/** 鍵值 */
	private Long id;
	
	/** 標題 */
	private String title;
	
	/** 描述 */
	private String descript;
	
	/** 圖檔名稱 */
	private String imgName;
	
	/** 定價 */
	private Integer listPrice;
	
	/** 特價 */
	private Integer salesPrice;
	
	/** 定價呈現 */
	private String listPriceDisplay;
	
	/** 特價呈現 */
	private String salesPriceDisplay;
	
	/** 是否高光焦點 */
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

	public String getListPriceDisplay() {
		return listPriceDisplay;
	}

	public void setListPriceDisplay(String listPriceDisplay) {
		this.listPriceDisplay = listPriceDisplay;
	}

	public String getSalesPriceDisplay() {
		return salesPriceDisplay;
	}

	public void setSalesPriceDisplay(String salesPriceDisplay) {
		this.salesPriceDisplay = salesPriceDisplay;
	}

	public boolean isHighLight() {
		return highLight;
	}

	public void setHighLight(boolean highLight) {
		this.highLight = highLight;
	}
	
}
