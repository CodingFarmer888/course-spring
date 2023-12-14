package com.ecommerce.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.dto.OrderDto;
import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.entity.Order;
import com.ecommerce.model.entity.OrderProduct;
import com.ecommerce.model.entity.Product;
import com.ecommerce.model.vo.ProductLineItem;

public class ControllerHelper {

    public static String convertToBase64(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        byte[] base64Encoded = Base64.encodeBase64(bytes);
        return new String(base64Encoded);
    }
    
    /**
     * 訂單物件轉換
     * @param order
     * @return
     */
    public static OrderDto convertToOrderDto(Order order) {
    	OrderDto orderDto = new OrderDto();
    	
    	List<ProductLineItem> productLineItems = new ArrayList<>();
    	List<OrderProduct> orderProductList = order.getOrderProducts();
    	
    	for (OrderProduct orderProduct : orderProductList) {
    		ProductLineItem item = new ProductLineItem();
    		Product product = orderProduct.getProduct();
    		item.setProductDto(convertToProductDto(product));
    		item.setQty(orderProduct.getQty());
    		productLineItems.add(item);
    	}
    	orderDto.setProductItemList(productLineItems);
    	orderDto.setTotalAmount(order.getTotalAmount());
    	orderDto.setOrderDate(order.getOrderDate());
    	
    	
    	return orderDto;
    }
    
	private static ProductDto convertToProductDto(Product product) {
		ProductDto dto = new ProductDto();
		dto.setProductId(product.getProductId());
		dto.setName(product.getName());
		dto.setBrand(product.getBrand());
		dto.setStatus(product.getStatus());
		dto.setStatusDisp(product.getStatus() == 1 ? "上架" : "下架");
		dto.setListPrice(product.getProductPrice().getListPrice());
		dto.setListPriceDisp(toTwdAmountDisp(product.getProductPrice().getListPrice()));
		dto.setSalesPrice(product.getProductPrice().getSalesPrice());
		dto.setSalesPriceDisp(toTwdAmountDisp(product.getProductPrice().getSalesPrice()));
		// 將Bytep[]轉成Base64給頁面呈現
		String base64Image = java.util.Base64.getEncoder().encodeToString(product.getImageData());
		// 圖檔需要指定格式，這裡設定為jpg，如果有其他格式，需要另外指定
		dto.setImgBase64("data:image/jpg;base64," + base64Image);
		return dto;
	}
	
	/**
	 * BigDecimal 轉 台幣顯示
	 * @param price
	 * @return
	 */
	private static String toTwdAmountDisp(BigDecimal price) {
		BigDecimal scaledPrice = price.setScale(0, RoundingMode.HALF_UP);
		return scaledPrice.toString();
	}
}
