package com.jovan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jovan.dao.UserDao;
import com.jovan.entity.DbUtil;
import com.jovan.entity.Users;



public class UserDaoImpl implements UserDao{
	//检查登录状况
	public Users Login(String user_id,String user_pwd){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		  try {
			  con = DbUtil.getConnection();
			  String sql = "select * from users where user_id=? and user_pwd=?";
			  stmt = con.prepareStatement(sql);
			  stmt.setString(1, user_id);
			  stmt.setString(2, user_pwd);
			  rs = stmt.executeQuery();
			  if(rs.next()){
//				  Users u = new Users(rs.getString("user_id"),rs.getString("user_pwd"),
//						  rs.getString("phone"),rs.getInt("is_admin"));
				  Users user = new Users();
				  user.setUser_id(rs.getString("user_id"));
				  user.setUser_pwd(rs.getString("user_pwd"));
				  user.setPhone(rs.getString("phone"));
				  user.setIs_admin(rs.getInt("is_admin"));
				  System.out.println("用户："+rs.getString("user_id")+"登录成功");
//				  System.out.println(rs.getString("user_pwd"));
//				  System.out.println("登录成功");
				  return user;
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  return null;
	  }
}
