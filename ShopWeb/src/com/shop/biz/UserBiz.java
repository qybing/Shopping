package com.shop.biz;

import com.shop.entity.User;

public interface UserBiz {
	// ≤È—Ø”√ªß
	public User findUser(String uname, String upwd) throws Exception;
}
