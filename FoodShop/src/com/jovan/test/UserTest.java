package com.jovan.test;

import java.util.List;

import com.jovan.biz.impl.CartItemBizImpl;
import com.jovan.dao.impl.FoodDaoImpl;
import com.jovan.dao.impl.UserDaoImpl;
import com.jovan.entity.CartItem;
import com.jovan.entity.Food;

public class UserTest {
	public static void main(String[] args) throws Exception {
		CartItemBizImpl cartItemBizImpl = new CartItemBizImpl();
		List<CartItem> cartItemList = cartItemBizImpl.addFoods(1, 1);
//		for(int i=0;i<3;i++){
//		System.out.println(foodList.get(i).getFood_name());
//		}
//		for(CartItem fod:cartItemList){
//			System.out.println(fod.getGname());
//			System.out.println(fod.getGprice());
//			System.out.println(fod.getNum());
		}
}

