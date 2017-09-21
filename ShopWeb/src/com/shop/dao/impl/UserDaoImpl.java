package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.util.DbUtil;

public class UserDaoImpl implements UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rst;
	
	
	public User findUser(String uname, String upwd) throws Exception {
		User user = null;
		conn = DbUtil.createConnection();
		String sqlStr = "select * from user where u_name = ? and u_pwd = ?";
		pstmt = conn.prepareStatement(sqlStr);
		pstmt.setString(1, uname);
		pstmt.setString(2, upwd);
		rst = pstmt.executeQuery();
		if(rst.next()){
			user = new User();
			user.setUid(rst.getInt("u_id"));
			user.setUname(rst.getString("u_name"));
			user.setUpwd(rst.getString("u_pwd"));
			user.setUsex(rst.getString("u_sex"));
			user.setUlevel(rst.getInt("u_level"));
		}
		return user;
	}

}
