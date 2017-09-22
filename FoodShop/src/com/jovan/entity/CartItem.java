package com.jovan.entity;

public class CartItem {
	private int id;
	private String gname;
	private float gprice;
	private int num;
	
	public CartItem() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public float getGprice() {
		return gprice;
	}
	public void setGprice(float gprice) {
		this.gprice = gprice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
