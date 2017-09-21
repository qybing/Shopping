package com.shop.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class DbUtil {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Connection conn = null;
	public static Connection createConnection() throws Exception{
		if(conn==null ||conn.isClosed()){
			String url = "jdbc:mysql://localhost:3306/shopweb?useSSL=false";
			String uname = "root";
			String upwd = "123456";
			conn = DriverManager.getConnection(url,uname,upwd);
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rst) throws Exception{
		if(rst!=null)
			rst.close();
		if(stmt!=null)
			stmt.close();
		if(conn!=null)
			conn.close();
	}
	public static void close(Connection conn, Statement stmt) throws Exception{
		if(stmt!=null)
			stmt.close();
		if(conn!=null)
			conn.close();
	}
	public static void close(Connection conn) throws Exception{
		if(conn!=null)
			conn.close();
	}
	
	public static int exeQuary(String sqlStr, Object...objs) throws Exception{
		int num = -1;
		Connection conn = createConnection();
		PreparedStatement pstmt = conn.prepareStatement(sqlStr);
		if(objs!=null){
			for(int i = 0; i < objs.length; i++)
				pstmt.setObject(i+1, objs[i]);
		}
		num = pstmt.executeUpdate();
		close(conn);
		return num;
	}
}
