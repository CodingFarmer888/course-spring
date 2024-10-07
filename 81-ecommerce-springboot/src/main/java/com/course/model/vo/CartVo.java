package com.course.model.vo;

import java.util.ArrayList;
import java.util.List;

public class CartVo {

	private List<ProductItem> itemList = new ArrayList<>();

	public List<ProductItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<ProductItem> itemList) {
		this.itemList = itemList;
	}
	
}
