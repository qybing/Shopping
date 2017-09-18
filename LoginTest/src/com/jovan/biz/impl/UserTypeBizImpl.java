package com.jovan.biz.impl;

import java.sql.Connection;
import java.util.List;

import com.jovan.biz.UserTypeBiz;
import com.jovan.dao.UserTypeDao;
import com.jovan.dao.impl.UserTypeDaoImpl;
import com.jovan.entity.User;
import com.jovan.entity.UserType;
import com.jovan.util.DbUtil;

public class UserTypeBizImpl implements UserTypeBiz{
	private UserTypeDao  userTypeDao = new UserTypeDaoImpl();
	public List<UserType> UserAdmin(User user) throws Exception{
		Connection conn = DbUtil.getConnection();
		List<UserType> userTypeList = userTypeDao.UserAdmin(user);
		conn.close();
		return userTypeList;
		
	}
	

}
