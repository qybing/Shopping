package com.newcapect.eshop.entity;

import java.sql.Date;

public class Goods {

	    private int gcode;
	    private String gname;
	    private double gprice;
	    private Date mdate;
	    private String gdesc;
	    private String gpic;
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
		public Date getMdate() {
			return mdate;
		}
		public void setMdate(Date mdate) {
			this.mdate = mdate;
		}
		public String getGdesc() {
			return gdesc;
		}
		public void setGdesc(String gdesc) {
			this.gdesc = gdesc;
		}
		public String getGpic() {
			return gpic;
		}
		public void setGpic(String gpic) {
			this.gpic = gpic;
		}
		public Goods( String gname, double gprice, String gdesc, String gpic) {
			super();
	       
			this.gname = gname;
			this.gprice = gprice;

			this.gdesc = gdesc;
			this.gpic = gpic;
		}
		public Goods(String gname, double gprice, Date mdate, String gdesc, String gpic) {
			super();
			this.gname = gname;
			this.gprice = gprice;
			this.mdate = mdate;
			this.gdesc = gdesc;
			this.gpic = gpic;
		}
		

		
	    
	    
	
	
}
