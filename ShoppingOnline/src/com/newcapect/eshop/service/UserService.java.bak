package com.newcapect.eshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.newcapect.eshop.entity.DbUtil;
import com.newcapect.eshop.entity.Users;
//import com.newcapect.eshop.entity.Users;

public class UserService {
  public int changePassword(int id,String old,String first,String second){
	   Connection con = null;
	   PreparedStatement stmt = null;
	   ResultSet rs = null;
	   try {
		   con = DbUtil.getConnection();
		   String sql= "select password from t_users where id=?";
		   stmt = con.prepareStatement(sql);
		   stmt.setInt(1, id);
		   rs = stmt.executeQuery();
		   rs.next();
		   String oldpwd = rs.getString("password");
		   stmt.close();
		   if(!oldpwd.equals(old)){
			   System.out.println("原密码错误");
			   return 0;
		   }
		   if (!first.equals(second)){
			   System.out.println("两次密码不一样");
			   return 0;
		   }
		   sql = "update t_users set password=? where id =?";
		   stmt = con.prepareStatement(sql);
		   stmt.setString(1, first);
		   stmt.setInt(2, id);
		   int rows = stmt.executeUpdate();
		   return rows;
		   
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	   return 0;
	}
  
  public int find_addr(int email){
	  Connection con = null;
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
	  try {
		con = DbUtil.getConnection();
		String sql = "select  addr1 from t_users where email=?";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  
	  
	  
	return email;
	  
  }
  
  
  public Users login(String userid,String password){
	  Connection con = null;
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
	  try {
		  con = DbUtil.getConnection();
		  String sql = "select * from t_users where email=? and password=?";
		  stmt = con.prepareStatement(sql);
		  stmt.setString(1, userid);
		  stmt.setString(2, password);
		  rs = stmt.executeQuery();
		  if(rs.next()){
			  Users u = new Users(rs.getString("email"),
					  rs.getString("password"),
					  rs.getString("addr1"));
			  u.setId(rs.getInt("id"));
			  return u;
		  }
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	  
	  return null;
  }
  
  public boolean register(String user_email,String user_password,String user_addr1){
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		con = DbUtil.getConnection();
		String sql = "insert into t_users(email,password,addr1) values(?,?,?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, user_email);
		stmt.setString(2, user_password);
		stmt.setString(3, user_addr1);
		int rows = stmt.executeUpdate();
		if(rows==1)
	    	return true;
		else
			return false;
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	  return false;
	  
  }
}
