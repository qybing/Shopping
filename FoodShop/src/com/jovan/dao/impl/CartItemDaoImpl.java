package com.jovan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jovan.dao.CartItemDao;
import com.jovan.entity.CartItem;
import com.jovan.entity.DbUtil;

public class CartItemDaoImpl implements CartItemDao {
	
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public List<CartItem> addFoods(int id,int num) throws Exception{
		List <CartItem> cartItemList = new ArrayList<>();
		con = DbUtil.getConnection();
		String sql = "select * from food where id =?";
		stmt = con.prepareCall(sql);
		stmt.setInt(1,id);
		rs = stmt.executeQuery();
		while(rs.next()){
			CartItem cartItem = new CartItem();
			cartItem.setId(rs.getInt("id"));
			cartItem.setGname(rs.getString("food_name"));
			cartItem.setGprice(rs.getFloat("food_price"));
			cartItem.setNum(num);
			cartItemList.add(cartItem);
			
		}
		return cartItemList;
	}
}
