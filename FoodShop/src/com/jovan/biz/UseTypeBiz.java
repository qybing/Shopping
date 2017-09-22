package com.jovan.biz;

import java.util.List;

import com.jovan.entity.UserType;
import com.jovan.entity.Users;

public interface UseTypeBiz {
	public List<UserType> findUserType(Users users) throws Exception;
	

}
