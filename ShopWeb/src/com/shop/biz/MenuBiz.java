package com.shop.biz;

import java.util.List;

import com.shop.entity.Menu;
import com.shop.entity.User;

public interface MenuBiz {
	public List<Menu> findMenuByUser(User user) throws Exception;
}
