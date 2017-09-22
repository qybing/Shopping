package com.jovan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jovan.dao.UserTypeDao;
import com.jovan.entity.DbUtil;
import com.jovan.entity.UserType;
import com.jovan.entity.Users;

public class UserTypeDaoImpl implements UserTypeDao{
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public List<UserType> findUserType(Users users) throws Exception{
		List<UserType> usertypelist = new ArrayList<>();
		con = DbUtil.getConnection();
		String sql = "select * from user_type where is_admin = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, users.getIs_admin());
		rs = stmt.executeQuery();
		while(rs.next()){
			UserType usertype = new UserType();
			usertype.setId(rs.getInt("id"));
			usertype.setItem_name(rs.getString("item_name"));
			usertype.setItem_url(rs.getString("item_url"));
			usertype.setIs_admin(rs.getInt("is_admin"));
			usertypelist.add(usertype);
		}
		
		return usertypelist;
	}
		

}
