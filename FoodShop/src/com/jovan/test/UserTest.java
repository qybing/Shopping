package com.jovan.test;

import java.util.List;

import com.jovan.biz.impl.CartItemBizImpl;
import com.jovan.biz.impl.FoodBizImpl;
import com.jovan.dao.impl.FoodDaoImpl;
import com.jovan.dao.impl.UserDaoImpl;
import com.jovan.entity.CartItem;
import com.jovan.entity.Food;

public class UserTest {
	public static void main(String[] args) throws Exception {
		FoodBizImpl foodBizImpl = new FoodBizImpl();
		Food food = new Food();
		System.out.println(food.getFood_name());
		int pages = foodBizImpl.findFoodsPages(food);
		System.out.println(pages);
//		System.out.println(food.getFood_name());
//		System.out.println(food.getFood_picture());
		}
}

