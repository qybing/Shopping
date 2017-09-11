package com.newcapect.eshop.entity;

public class OrderItem {
    private  int icode ; 
	private  int gcode ; 
	private  String gname ; 
	private  double gprice ; 
	private  int gcount ;
	public OrderItem(int gcode, String gname, double gprice, int gcount) {
		super();
		this.gcode = gcode;
		this.gname = gname;
		this.gprice = gprice;
		this.gcount = gcount;
	}
	public OrderItem() {
		super();
	}
	public int getGcode() {
		return gcode;
	}
	public void setGcode(int gcode) {
		this.gcode = gcode;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	public int getGcount() {
		return gcount;
	}
	public void setGcount(int gcount) {
		this.gcount = gcount;
	} 
	

}
