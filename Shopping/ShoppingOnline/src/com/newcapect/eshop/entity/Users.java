package com.newcapect.eshop.entity;

public class Users {
   private int id;
   private String email;
   private String password;
   private String addr1;
public Users(int id, String email, String password, String addr1) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.addr1 = addr1;
}
public Users() {
	super();
}

public Users(String email, String password, String addr1) {
	super();
	this.email = email;
	this.password = password;
	this.addr1 = addr1;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddr1() {
	return addr1;
}
public void setAddr1(String addr1) {
	this.addr1 = addr1;
}
   
}
