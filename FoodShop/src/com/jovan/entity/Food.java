package com.jovan.entity;

public class Food {
	private Integer id;
	private String food_name;
	private String food_store;
	private float food_price;
	private Integer min_price;
	private Integer  max_price;
	private String food_picture;
	public Food() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_store() {
		return food_store;
	}
	public void setFood_store(String food_store) {
		this.food_store = food_store;
	}
	public float getFood_price() {
		return food_price;
	}
	public void setFood_price(float food_price) {
		this.food_price = food_price;
	}
	public String getFood_picture() {
		return food_picture;
	}
	public void setFood_picture(String food_picture) {
		this.food_picture = food_picture;
	}
	public Integer getMin_price() {
		return min_price;
	}
	public void setMin_price(Integer min_price) {
		this.min_price = min_price;
	}
	public Integer getMax_price() {
		return max_price;
	}
	public void setMax_price(Integer max_price) {
		this.max_price = max_price;
	}
	
	

}
