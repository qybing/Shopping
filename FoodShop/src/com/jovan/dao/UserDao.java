package com.jovan.dao;

import com.jovan.entity.Users;

public interface UserDao {
	public Users Login(String user_id,String user_pwd) throws Exception;
}
