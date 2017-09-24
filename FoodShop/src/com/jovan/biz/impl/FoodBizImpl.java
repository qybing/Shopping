package com.jovan.biz.impl;

import java.sql.Connection;
import java.util.List;

import com.jovan.biz.FoodBiz;
import com.jovan.dao.FoodDao;
import com.jovan.dao.impl.FoodDaoImpl;
import com.jovan.entity.DbUtil;
import com.jovan.entity.Food;

public class FoodBizImpl implements FoodBiz {
	private FoodDao fooddao = new FoodDaoImpl();
    
	public List<Food> findAllFoods() throws Exception{
		Connection con = DbUtil.getConnection();
		List<Food> foodlist = fooddao.findAllFoods();
		DbUtil.close(con);
		return foodlist;
		
	}
	public List<Food> findFoods(Food food) throws Exception{
		Connection con = DbUtil.getConnection();
		List<Food> foodlist = fooddao.findFoods(food);
		DbUtil.close(con);
		return foodlist;
	}
	public Food findFoodsById(int food_id) throws Exception{
		Connection con = DbUtil.getConnection();
		Food food = fooddao.findFoodsById(food_id);
		con.close();
		return food;
		
	}

}
