package com.shop.biz.impl;

import java.sql.Connection;

import com.shop.biz.UserBiz;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.entity.User;
import com.shop.util.DbUtil;

public class UserBizImpl implements UserBiz {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public User findUser(String uname, String upwd) throws Exception {
		Connection conn = DbUtil.createConnection();
		User user = userDao.findUser(uname, upwd);
		DbUtil.close(conn);
		return user;
	}
}
