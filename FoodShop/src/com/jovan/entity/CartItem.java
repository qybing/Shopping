package com.jovan.entity;

public class CartItem {
	private Integer count;
	private Food food;
	
	
//	private String gname;
//	private float gprice;
//	private int num;
	
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public CartItem() {
		super();
	}
    
//	public String getGname() {
//		return gname;
//	}
//	public void setGname(String gname) {
//		this.gname = gname;
//	}
//	public float getGprice() {
//		return gprice;
//	}
//	public void setGprice(float gprice) {
//		this.gprice = gprice;
//	}
//	public int getNum() {
//		return num;
//	}
//	public void setNum(int num) {
//		this.num = num;
//	}
	
	
}
