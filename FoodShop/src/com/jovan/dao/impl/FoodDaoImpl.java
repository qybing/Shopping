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
	
/*	public List<Food> findAllFoods() throws Exception{
		List<Food> foodList = new ArrayList<>();
		con = DbUtil.getConnection();
		String sql = "select * from food";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()){
			Food food = new Food(); 
			food.setId(rs.getInt("id"));
			food.setFood_name(rs.getString("food_name"));
			food.setFood_price(rs.getDouble("food_price"));
			food.setFood_store(rs.getString("food_store"));
			food.setFood_picture(rs.getString("food_picture"));
			foodList.add(food);
			
		}
		return foodList;	
	}*/
	public Food findFoodsById(int food_id) throws Exception{
		Food food = null;
		con = DbUtil.getConnection();
		String sql = "select * from food where id =?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, food_id);
		rs = stmt.executeQuery();
		if(rs.next()){
			food = new Food();
			food.setId(food_id);
			food.setFood_name(rs.getString("food_name"));
			food.setFood_store(rs.getString("food_store"));
			food.setFood_price(rs.getDouble("food_price"));
			food.setFood_picture(rs.getString("food_picture"));
		}
		return food;
	}
	//显示当前页数的，商品列表
	public List<Food> findFoods(int page,Food food) throws Exception{
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
		sql=sql+") temp limit ?,2";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, (page-1)*2);
		rs = stmt.executeQuery();
		while(rs.next()){
			Food f = new Food();
			f.setId(rs.getInt("id"));
			f.setFood_name(rs.getString("food_name"));
			f.setFood_picture(rs.getString("food_picture"));
			f.setFood_store(rs.getString("food_store"));
			f.setFood_price(rs.getDouble("food_price"));
			foodList.add(f);
			
		}
		return foodList;
		
	}
	//计算总页数
	public int findFoodsPages(Food food) throws Exception{
		con = DbUtil.getConnection();
		String sql = "select count(1) as ts from food where 1=1";
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
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		int count = 0;
		while(rs.next()){
			 count = rs.getInt(1);
		}
//		System.out.println(count);
//		int rows = rs.getInt("ts");
		if(count%2==0)
			return count/2;
		return count/2+1;
	}
}
