package com.jovan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jovan.dao.FoodDao;
import com.jovan.entity.CartItem;
import com.jovan.entity.DbUtil;
import com.jovan.entity.Food;

public class FoodDaoImpl implements FoodDao{
	
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public List<Food> findAllFoods() throws Exception{
		List<Food> foodList = new ArrayList<>();
		con = DbUtil.getConnection();
		String sql = "select * from food";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()){
			Food food = new Food(); 
			food.setId(rs.getInt("id"));
			food.setFood_name(rs.getString("food_name"));
			food.setFood_price(rs.getFloat("food_price"));
			food.setFood_store(rs.getString("food_store"));
			food.setFood_picture(rs.getString("food_picture"));
			foodList.add(food);
			
		}
		return foodList;	
	}
	
	
	public List<Food> findFoods(Food food) throws Exception{
		List<Food> foodList = new ArrayList<>();
		con = DbUtil.getConnection();
		String sql = "select * from(select f.* from food f where 1=1";
		if(food!=null){
			if(food.getFood_name()!=null){
				sql = sql + " and food_name like '%"+food.getFood_name()+"%'";
			}
			if(food.getMin_price()!=null){
				sql = sql + " and food_price >"+food.getMin_price()+" ";
			}
			if(food.getMax_price()!=null){
				sql = sql + " and food_price < "+food.getMax_price()+" ";
			}
		}
		sql=sql+") temp limit ?,6";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, 0);
		rs = stmt.executeQuery();
		while(rs.next()){
			Food f = new Food();
			f.setId(rs.getInt("id"));
			f.setFood_name(rs.getString("food_name"));
			f.setFood_picture(rs.getString("food_picture"));
			f.setFood_store(rs.getString("food_store"));
			f.setFood_price(rs.getFloat("food_price"));
			foodList.add(f);
			
		}
		return foodList;
		
	}
	
	

}
