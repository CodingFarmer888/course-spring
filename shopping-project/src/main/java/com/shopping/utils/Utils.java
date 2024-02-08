package com.shopping.utils;

import com.shopping.model.CartInfo;

import jakarta.servlet.http.HttpServletRequest;

public class Utils {

	// 從Session中取得購物車中的商品
	public static CartInfo getCartInSession(HttpServletRequest request) {
		CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");

		if (cartInfo == null) {
			cartInfo = new CartInfo();
			request.getSession().setAttribute("myCart", cartInfo);
		}
		return cartInfo;
	}

	// 從Session中移除購物車
	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}

	// 將最後訂購的購物車存入Session中
	public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
		request.getSession().setAttribute("lastOrderedCart", cartInfo);
	}

	// 從Session中取得最後訂購的購物車
	public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
		return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
	}
}
