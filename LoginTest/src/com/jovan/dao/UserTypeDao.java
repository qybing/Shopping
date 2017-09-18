package com.jovan.dao;

import java.util.List;

import com.jovan.entity.User;
import com.jovan.entity.UserType;

public interface UserTypeDao {
	public List<UserType> UserAdmin(User user) throws Exception;
}
