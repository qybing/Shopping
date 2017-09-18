package com.jovan.biz;

import java.util.List;

import com.jovan.entity.User;
import com.jovan.entity.UserType;

public interface UserTypeBiz {
	public List<UserType> UserAdmin(User user) throws Exception;
}
