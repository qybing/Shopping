package com.jovan.biz;

import java.util.List;

import com.jovan.entity.Food;

public interface FoodBiz {
	public List<Food> findFoods(int pages,Food food) throws Exception;
	public Food findFoodsById(int food_id) throws Exception;
	public int findFoodsPages(Food food) throws Exception;	
}
