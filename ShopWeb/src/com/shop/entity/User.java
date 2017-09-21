package com.shop.entity;

import java.io.Serializable;

public class User implements Serializable{
	private Integer uid;
	private String uname;
	private String upwd;
	private String usex;
	private Integer ulevel;
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public Integer getUlevel() {
		return ulevel;
	}
	public void setUlevel(Integer ulevel) {
		this.ulevel = ulevel;
	}
	
	
	
}
