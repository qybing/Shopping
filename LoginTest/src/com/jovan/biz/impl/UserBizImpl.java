package com.jovan.biz.impl;

import java.sql.Connection;

import com.jovan.biz.UserBiz;
import com.jovan.dao.UserDao;
import com.jovan.dao.impl.UserDaoImpl;
import com.jovan.entity.User;
import com.jovan.util.DbUtil;

public class UserBizImpl implements UserBiz {
	private UserDao userdao = new UserDaoImpl();
	public User login(String account,String pwd) throws Exception{
		Connection conn = DbUtil.getConnection();
		User user = userdao.login(account, pwd);
		conn.close();
		return  user;
		
	}

}
