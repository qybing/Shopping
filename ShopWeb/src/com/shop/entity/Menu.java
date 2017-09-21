package com.shop.entity;

import java.io.Serializable;

public class Menu implements Serializable {
	private Integer mid;
	private String mname;
	private Integer ulevel;
	private String address;
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Integer getUlevel() {
		return ulevel;
	}
	public void setUlevel(Integer ulevel) {
		this.ulevel = ulevel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
