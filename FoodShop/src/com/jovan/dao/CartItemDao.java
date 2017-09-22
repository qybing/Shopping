package com.jovan.dao;

import java.util.List;

import com.jovan.entity.CartItem;

public interface CartItemDao {
	
	public List<CartItem> addFoods(int id,int num) throws Exception;

}
