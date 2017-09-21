package com.jovan.biz.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jovan.biz.UseTypeBiz;
import com.jovan.dao.UserTypeDao;
import com.jovan.dao.impl.UserTypeDaoImpl;
import com.jovan.entity.DbUtil;
import com.jovan.entity.UserType;
import com.jovan.entity.Users;


public class UserTypeBizImpl implements UseTypeBiz{
	private UserTypeDao usertypedao = new UserTypeDaoImpl();
	public List<UserType> findUserType(Users users) throws Exception{
		Connection con =  DbUtil.getConnection();
		List<UserType> usertypelist = usertypedao.findUserType(users);
		DbUtil.close(con);
		return usertypelist;
		
	}

}
