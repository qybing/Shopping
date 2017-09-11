package com.newcapect.eshop.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DbUtil {
	 private static String user = "root";
	 private static String password = "123456";
	 private static  String url = "jdbc:mysql://localhost:3306/eshop?characterEncoding=utf-8";
	 public static Connection getConnection(){
	 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	    Connection con=null;
	    try {
			con = DriverManager.getConnection(url,user,password);
		    return con;
	 } catch (SQLException e) {
			e.printStackTrace();
		}
	    return null;
}
	public static void setUser(String user) {
		DbUtil.user = user;
	}
	public static void setPassword(String password) {
		DbUtil.password = password;
	}
	public static void setUrl(String url) {
		DbUtil.url = url;
	}
	
}

