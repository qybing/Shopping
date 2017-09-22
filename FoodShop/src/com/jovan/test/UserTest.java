package com.jovan.test;

import java.util.List;

import com.jovan.dao.impl.FoodDaoImpl;
import com.jovan.dao.impl.UserDaoImpl;
import com.jovan.entity.Food;

public class UserTest {
	public static void main(String[] args) throws Exception {
		FoodDaoImpl f = new FoodDaoImpl();
		Food food = new Food();
		food.setFood_name("ÈýÖ»");
		List<Food> foodList = f.findFoods(food);
//		for(int i=0;i<3;i++){
//		System.out.println(foodList.get(i).getFood_name());
//		}
		for(Food fod:foodList){
			System.out.println(fod.getFood_name());
		}
}
}
