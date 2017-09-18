package com.jovan.entity;

public class UserType {
	 private int id;
	 private String item_name;
	 private String item_url;
	 private int is_admin;
	public UserType() {
		super();
	}
	public UserType(int id, String item_name, String item_url, int is_admin) {
		super();
		this.id = id;
		this.item_name = item_name;
		this.item_url = item_url;
		this.is_admin = is_admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_url() {
		return item_url;
	}
	public void setItem_url(String item_url) {
		this.item_url = item_url;
	}
	public int getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}
	 
	 

}
