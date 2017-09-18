package com.jovan.entity;

public class User {
	private int id;
	private String acct;
	private String pwd;
    private int is_admin;
    
	public User() {
		super();
	}
	public User(int id, String acct, String pwd, int is_admin) {
		super();
		this.id = id;
		this.acct = acct;
		this.pwd = pwd;
		this.is_admin = is_admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcct() {
		return acct;
	}
	public void setAcct(String acct) {
		this.acct = acct;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}
    
    
}
