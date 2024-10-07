package com.course.utils;

import org.springframework.stereotype.Service;

import com.course.model.entity.ProductEntity;
import com.course.model.session.CartSession;
import com.course.model.vo.CartVo;
import com.course.model.vo.ProductVo;

@Service
public class EcUtils {
	
	/**
	 * 將 Entity 轉換 成 Vo
	 * @param entity
	 * @return
	 */
	public ProductVo convertToVo(ProductEntity entity) {
		ProductVo vo = new ProductVo();
		vo.setCode(entity.getCode());
		vo.setName(entity.getName());
		vo.setListPrice(entity.getListPrice());
		vo.setSalesPrice(entity.getSalesPrice());
		vo.setQuantity(entity.getQuantity());
		vo.setImageUrl("http://localhost:8080/images/" + entity.getImageName());
		return vo;
	}
	
	/**
	 * 將 Entity 轉換 成 Vo
	 * @param entity
	 * @return
	 */
	public CartVo convertToCartVo(CartSession cartSession) {
		CartVo vo = new CartVo();
//		vo.setCode(entity.getCode());
//		vo.setName(entity.getName());
//		vo.setListPrice(entity.getListPrice());
//		vo.setSalesPrice(entity.getSalesPrice());
//		vo.setQuantity(entity.getQuantity());
//		vo.setImageUrl("http://localhost:8080/images/" + entity.getImageName());
		return vo;
	}
}
