package com.shop.biz;

import com.shop.entity.User;

public interface UserBiz {
	// ��ѯ�û�
	public User findUser(String uname, String upwd) throws Exception;
}
