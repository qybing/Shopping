package com.shop.dao;

import com.shop.entity.User;

public interface UserDao {
	public User findUser(String uname, String upwd) throws Exception;
}
