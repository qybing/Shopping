package com.jovan.entity;

public class Users {
	private String user_id;
    private String user_pwd;
    private String phone;
    private int is_admin; 
    
	public Users(String user_id, String user_pwd, String phone, int is_admin) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.phone = phone;
		this.is_admin = is_admin;
	}

	public Users() {
		super();
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}
	
    
}
