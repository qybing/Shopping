package com.jovan.biz.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jovan.biz.CartItemBiz;
import com.jovan.dao.CartItemDao;
import com.jovan.dao.impl.CartItemDaoImpl;
import com.jovan.entity.CartItem;
import com.jovan.entity.DbUtil;

public class CartItemBizImpl implements CartItemBiz{
	private CartItemDao cartItemDao = new CartItemDaoImpl();
	
	public List<CartItem> addFoods(int id,int num) throws Exception{
		Connection con = DbUtil.getConnection();
		List<CartItem> cartItemList = cartItemDao.addFoods(id, num);
		con.close();
		return cartItemList;
		
	}
	

}
