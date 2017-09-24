package com.jovan.dao;

import java.util.List;

import com.jovan.entity.Food;

public interface FoodDao {
	
	public List<Food> findAllFoods() throws Exception;
	public List<Food> findFoods(Food food) throws Exception;
	public Food findFoodsById(int food_id) throws Exception;

}
