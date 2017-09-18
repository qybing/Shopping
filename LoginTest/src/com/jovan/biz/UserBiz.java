package com.jovan.biz;

import com.jovan.entity.User;

public interface UserBiz {
	public User login(String account,String pwd) throws Exception;

}
