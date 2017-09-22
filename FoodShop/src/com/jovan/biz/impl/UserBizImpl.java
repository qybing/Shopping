package com.jovan.biz.impl;

import java.sql.Connection;

import com.jovan.biz.Userbiz;
import com.jovan.dao.UserDao;
import com.jovan.dao.impl.UserDaoImpl;
import com.jovan.entity.DbUtil;
import com.jovan.entity.Users;

public class UserBizImpl implements Userbiz{
	private UserDao userdao = new UserDaoImpl();
	public Users Login(String user_id,String user_pwd)throws Exception {
		Connection con = null;
		con = DbUtil.getConnection();
		Users users = userdao.Login(user_id, user_pwd);
		DbUtil.close(con);
		return users;
		
	}
	

}
