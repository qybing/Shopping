package com.jovan.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	private static String user = "root";
	private static String password = "123456";
	private static String url = "jdbc:mysql://localhost:3306/market?characterEncoding=utf-8";
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
//	public static void close(){
//		
//		    
//	}
	public static void close(Connection con, Statement stmt, ResultSet st) throws Exception{
		if(st!=null)
			st.close();
		if(stmt!=null)
			stmt.close();
		if(con!=null)
			con.close();
	}
	public static void close(Connection con, Statement stmt) throws Exception{
		if(stmt!=null)
			stmt.close();
		if(con!=null)
			con.close();
	}
	public static void close(Connection con) throws Exception{
		if(con!=null)
			con.close();
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