package com.jovan.dao;

import java.util.List;

import com.jovan.entity.UserType;
import com.jovan.entity.Users;

public interface UserTypeDao {
	public List<UserType> findUserType(Users users) throws Exception;
}
