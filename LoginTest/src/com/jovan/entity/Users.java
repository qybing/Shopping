package com.jovan.entity;

public class Users {
	private String user_id;
    private String user_pwd;
    
	public Users() {
		super();
	}
	public Users(String user_id, String user_pwd) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
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
    
}
