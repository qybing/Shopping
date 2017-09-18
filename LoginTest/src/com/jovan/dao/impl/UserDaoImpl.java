package com.jovan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jovan.dao.UserDao;
import com.jovan.entity.User;
import com.jovan.util.DbUtil;

public class UserDaoImpl implements UserDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public User login(String account,String pwd) throws Exception{
		conn =  DbUtil.getConnection();
		String sql = "select * from user where account=? and pwd=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account);
		pstmt.setString(2, pwd);
		rs = pstmt.executeQuery();
		if(rs.next()){
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setAcct(rs.getString("account"));
			user.setPwd(rs.getString("pwd"));
			user.setIs_admin(rs.getInt("is_admin"));
			return user;
		}
		
		return null;
		
	}

}
