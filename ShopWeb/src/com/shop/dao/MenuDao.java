package com.shop.dao;

import java.util.List;

import com.shop.entity.Menu;
import com.shop.entity.User;

public interface MenuDao {
	public List<Menu> findMenuByUser(User user) throws Exception;
}
