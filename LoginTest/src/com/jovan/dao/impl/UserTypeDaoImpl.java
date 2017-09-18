package com.jovan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jovan.dao.UserTypeDao;
import com.jovan.entity.User;
import com.jovan.entity.UserType;
import com.jovan.util.DbUtil;

public class UserTypeDaoImpl implements UserTypeDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public List<UserType> UserAdmin(User user) throws Exception{
		List<UserType> userTypeList = new ArrayList<>();
		conn = DbUtil.getConnection();
		String sql = "select * from user_type where is_admin=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user.getIs_admin());
		rs = pstmt.executeQuery();
		while(rs.next()){
			UserType userType = new UserType();
			userType.setId(rs.getInt("id"));
			userType.setItem_name(rs.getString("item_name"));
			userType.setItem_url(rs.getString("item_url"));
			userType.setIs_admin(rs.getInt("is_admin"));
			userTypeList.add(userType);
			
		}
		return userTypeList;
	}
}
