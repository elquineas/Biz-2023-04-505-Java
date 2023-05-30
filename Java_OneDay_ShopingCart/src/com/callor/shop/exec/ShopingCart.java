package com.callor.shop.exec;

import com.callor.shop.service.ShopingCartService;

public class ShopingCart {
	public static void main(String[] args) {
		ShopingCartService scService = new ShopingCartService();
		scService.shopingCart();
	}
}
