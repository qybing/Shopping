package com.jovan.biz;

import java.util.List;

import com.jovan.entity.CartItem;

public interface CartItemBiz {	
	public List<CartItem> addFoods(int id,int num) throws Exception;
}
