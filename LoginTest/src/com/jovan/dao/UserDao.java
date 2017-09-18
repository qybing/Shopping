package com.jovan.dao;

import com.jovan.entity.User;

public interface UserDao {
	public User login(String account,String pwd) throws Exception;
}
